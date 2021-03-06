package egov.border.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egov.border.domain.BorderVO;
import egov.border.domain.PointVO;
import egov.border.service.BorderService;
import egov.border.service.PointService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class BorderController {

	private static final Logger logger = LoggerFactory.getLogger(BorderController.class);

	@Resource(name = "borderService")
	public BorderService borderService;

	@Resource(name = "pointService")
	public PointService pointService;

	@Resource(name = "fileUploadProperty")
	public Properties properties;

	@RequestMapping("/borderWrite.do")
	public String borderWrite(HttpServletRequest request, ModelMap model) {

		String userId = "";

		if (request.getSession().getAttribute("user_id") == null) {
			request.getSession().invalidate();
			return "redirect:/login.do";
		} else {
			userId = request.getSession().getAttribute("user_id").toString();
		}

		model.addAttribute("userId", userId);

		return "border/borderWrite";
	}

	@RequestMapping("/borderInsert.do")
	public String borderInsert(BorderVO vo, HttpServletRequest request) throws Exception {

		String title = request.getParameter("title").toString();
		String bordertext = request.getParameter("bordertext").toString();

		if (title.length() > 15) {
			return "redirect:/borderWrite.do";
		} else if (bordertext.length() > 2000) {
			return "redirect:/borderWrite.do";
		} else if (request.getSession().getAttribute("user_id") == null) {
			request.getSession().invalidate();
			return "redirect:/login.do";
		} else {
			vo.setWriterip(request.getRemoteAddr());
			vo.setUserid(request.getSession().getAttribute("user_id").toString());
		}

		// ??????????????? ??????
		// ????????? ????????????
		String convertuid = "";
		String uploadPath = properties.getProperty("file.uploadborderImg.path");
		String originalEx = "";
		String filePath = "";

		if (request instanceof MultipartHttpServletRequest) { // jsp????????? entype??? ???????????? ????????? if??? ??????
			final MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			final Map<String, MultipartFile> files = multiRequest.getFileMap();

			File saveFolder = new File(uploadPath);
			// ????????? ????????? || ???????????? ???????????? ??????
			if (!saveFolder.exists() || saveFolder.isFile()) {
				saveFolder.mkdirs();
			}

			Iterator<Entry<String, MultipartFile>> itr = files.entrySet().iterator();
			MultipartFile file;

			// ???????????? ????????? ???????????????.
			while (itr.hasNext()) {
				Entry<String, MultipartFile> entry = itr.next();
				file = entry.getValue();

				if (!"".equals(file.getOriginalFilename())) {
					int fileSize = (int) file.getSize();
					int maxSize = 1 * 1024 * 1024;
					if (fileSize > maxSize) {
						return "redirect:/borderWrite.do";
					}
					Calendar cal = Calendar.getInstance();
					int year = cal.get(Calendar.YEAR);
					int month = cal.get(Calendar.MONTH) + 1;
					int date = cal.get(Calendar.DATE);
					int hour = cal.get(Calendar.HOUR_OF_DAY);

					// ????????? ????????? ????????????
					convertuid = UUID.randomUUID().toString().replace("-", "") + year + month + date + hour;
					// ??????????????? ?????????
					originalEx = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);

					convertuid = convertuid + "." + originalEx;
					filePath = uploadPath + convertuid;
					file.transferTo(new File(filePath.replaceAll(" ", "")));
				}
			}
		}
		vo.setFilename(convertuid);
		vo.setFiletype(originalEx);
		vo.setFileurl("http://localhost:8080/test2/borderDetail/image.do?file=" + convertuid);

		borderService.insertBorder(vo);

		return "redirect:/borderList.do";
	}

	@RequestMapping("/borderList.do")
	public String borderList(@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNo,
			ModelMap model, BorderVO vo) throws Exception {

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(Integer.parseInt(pageNo));
		paginationInfo.setPageSize(10);
		paginationInfo.setRecordCountPerPage(10);

		vo.setCurrentPageNo(paginationInfo.getCurrentPageNo());

		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> list = borderService.selectBorderList(vo);
		paginationInfo.setTotalRecordCount(vo.getList_count());
		System.out.println(list);
		model.addAttribute("resultList", list);

		model.addAttribute("paginationInfo", paginationInfo);

		return "border/borderList";
	}

	// ResponseEntity<byte[]>, AbstractView - 2?????? ??????
	@RequestMapping("/borderDetail/image.do")
	public ResponseEntity<byte[]> imageShow(HttpServletRequest request, ModelMap model) throws Exception {

		request.setCharacterEncoding("UTF-8");

		String fileName = "";
		fileName = request.getParameter("file").toString();

		String uploadPath = properties.getProperty("file.uploadborderImg.path");

		// ????????? ???????????? ????????? ?????? InputStream
		InputStream in = null;
		// ??????????????? ????????? ??? ??? ?????????
		ResponseEntity<byte[]> entity = null;

		if (fileName.equals("") || fileName == null) {
			return null;
		}

		try {
			// ????????? ???????????? ?????? ??????
			// ???????????? ????????? ?????? ??????
			// ????????? ???????????? ???????????? ???????????? ??????

			HttpHeaders headers = new HttpHeaders();
			in = new FileInputStream(uploadPath + fileName);

			// ???????????? ?????? ?????? ??????
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.add("Content-Disposition",
					"attatchment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO-8859-1") + "\"");
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		} finally {
			in.close();
		}

		return entity;
	}

	@RequestMapping("/borderDetail.do")
	public String borderDetail(HttpServletRequest request, ModelMap model, BorderVO vo) throws Exception {

		BorderVO borderVO = borderService.selectBorderDetail(vo.borderid);

		if (request.getSession().getAttribute("user_id") == null) {
			model.addAttribute("userid", "");
		} else {
			model.addAttribute("userid", request.getSession().getAttribute("user_id").toString());
		}
		model.addAttribute("result", borderVO);

		return "border/borderDetail";
	}

	@RequestMapping("/borderReply.do")
	public String borderReply(HttpServletRequest request, ModelMap model, BorderVO vo) {

		String userid = "";

		if (request.getSession().getAttribute("user_id") == null) {
			request.getSession().invalidate();
			return "redirect:/login.do";
		} else {
			userid = request.getSession().getAttribute("user_id").toString();
		}

		model.addAttribute("userid", userid);
		model.addAttribute("borderid", vo.getBorderid());

		return "border/borderReply";
	}

	@RequestMapping("/borderReplyReq.do")
	public String borderReplyeq(HttpServletRequest request, ModelMap model, BorderVO vo) throws Exception {

		if (vo.title.length() > 15) {
			return "redirect:/borderList.do";
		} else if (vo.bordertext.length() > 2000) {
			return "redirect:/borderList.do";
		} else if (request.getSession().getAttribute("user_id") == null) {
			return "redirect:/borderList.do";
		} else {
			vo.setUserid(request.getSession().getAttribute("user_id").toString());
		}

		borderService.insertBorderReply(vo);

		return "redirect:/borderList.do";
	}

	@RequestMapping("/borderModify.do")
	public String borderModify(HttpServletRequest request, ModelMap model, BorderVO vo) throws Exception {

		String userid = "";

		if (request.getSession().getAttribute("user_id") == null) {
			request.getSession().invalidate();
			return "redirect:/login.do";
		} else {
			userid = request.getSession().getAttribute("user_id").toString();
		}

		BorderVO borderVO = borderService.selectBorderDetail(vo.getBorderid());
		borderVO.setUserid(userid);

		model.addAttribute("result", borderVO);

		return "border/borderModify";
	}

	@RequestMapping("/borderModifyReq.do")
	public String borderModifyReq(HttpServletRequest request, ModelMap model, BorderVO vo) throws Exception {
		if (vo.title.length() > 15) {
			return "redirect:/borderList.do";
		} else if (vo.bordertext.length() > 2000) {
			return "redirect:/borderList.do";
		} else if (request.getSession().getAttribute("user_id") == null) {
			return "redirect:/borderList.do";
		} else {
			vo.setUserid(request.getSession().getAttribute("user_id").toString());
		}

		vo.setEditip(request.getRemoteAddr());
		vo.setEditid(request.getSession().getAttribute("user_id").toString());

		borderService.updateBorderModify(vo);

		return "redirect:/borderList.do";
	}

	@RequestMapping("/borderDelete.do")
	public String borderDelete(HttpServletRequest request, BorderVO vo) throws Exception {

		String userid = "";
		if (request.getSession().getAttribute("user_id") == null) {
			request.getSession().invalidate();
			return "redirect:/login.do";
		} else {
			userid = request.getSession().getAttribute("user_id").toString();
		}

		if (vo.getGroup_tab() > 0) {
			vo.setTitle("????????? ??????");
		} else {
			vo.setTitle("????????? ???");
		}

		vo.setUserid(userid);
		vo.setEditip(request.getRemoteAddr());

		borderService.updateBorderDelete(vo);
		return "redirect:/borderList.do";
	}

	@RequestMapping("/proctest.do") 
	public String proctest(ModelMap model, PointVO vo) throws Exception {
	 
		vo.setPointid(1); 
		vo.setUserid("adc"); 
		vo.setBuypoint(100);
		pointService.proctest(vo);
		 
		vo.setPointid(2); 
		vo.setUserid("abc"); 
		vo.setBuypoint(100);
		pointService.proctest(vo);
		
		vo.setPointid(3); 
		vo.setUserid("abc"); 
		vo.setBuypoint(100);
		pointService.proctest(vo); 
		
		return "redirect:/borderList.do";  
	}
}
