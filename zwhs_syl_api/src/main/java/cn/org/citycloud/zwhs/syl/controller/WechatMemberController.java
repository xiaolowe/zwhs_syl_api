package cn.org.citycloud.zwhs.syl.controller;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.org.citycloud.zwhs.syl.constants.ErrorCodes;
import cn.org.citycloud.zwhs.syl.entity.WechatMember;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.WechatMemberService;
import cn.org.citycloud.zwhs.syl.utils.ExcelUtil;


@Controller
@RequestMapping("wechatmember")
public class WechatMemberController {
	
	@Autowired
	private WechatMemberService wechatMemberService;
	
	
	/**
	 * 获取会员列表
	 * 列表
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody()
	public Object getGoods(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "wechat_aliasname", required = false)  String wechatAliasname) throws Exception, RuntimeException {

		
		Sort sort = new Sort(Direction.DESC, "memberId");
	    Pageable pageable = new PageRequest(pageNo - 1, pageSize, sort);
	    
	    WechatMember wechatMember = new WechatMember(wechatAliasname);
	    
	    Page<WechatMember> list = wechatMemberService.getWechatMemberPage(pageable, wechatMember);
		return list;
	}
	
	/**
	 * 查看会员详情
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	@ResponseBody()
	public Object detailGoods(
			@RequestParam(value = "member_id") Integer memberId) throws Exception, RuntimeException {

		if(memberId == null){
			
			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
			
		}
		
		WechatMember wechatMember = wechatMemberService.getWechatMemberByMemberId(memberId);
		
		return wechatMember;
	}
	
	/**
	 * 编辑会员信息
	 * @return
	 */
//	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
//	@ResponseBody()
//	public Object modifyStoreInfo(@RequestBody Map<String, Object> params) throws Exception, RuntimeException {
//
//		Integer storeId = (Integer)params.get("store_id");
//		String companyName = (String)params.get("company_name");
//		String companyAddress = (String)params.get("company_address");
//		Integer storeState = (Integer)params.get("store_state");
//		Integer sgId = (Integer)params.get("sg_id");
//		BigDecimal commisRates = (BigDecimal)params.get("commis_rates");
//		String provinceId = (String)params.get("province_id");
//		String provinceName = (String)params.get("province_name");
//		String cityId = (String)params.get("city_id");
//		String cityName = (String)params.get("city_name");
//		String areaId = (String)params.get("area_id");
//		String areaName = (String)params.get("area_name");
//		
//		if(storeId == null ){
//			
//			throw new BusinessErrorException(ErrorCodes.PARAM_ERROR, "参数为空");
//			
//		}
//		Date now = new Date();
//		
//		Store store = new Store(commisRates, companyAddress, companyName,
//				areaId, areaName, cityId, cityName,
//				provinceId, provinceName, sgId, storeState, now);
//		
//		Store storeupdate = storeService.modifyStoreByInfo(storeId, store);
//		
//		return storeupdate;
//	}
	
	
	/**
	 * 导出报表
	 */
	@RequestMapping(value="downloadExcel", method = RequestMethod.GET)
    public String download(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
	        @RequestParam(value = "pageSize", defaultValue = "10")  Integer pageSize,
	        @RequestParam(value = "wechat_aliasname", required = false)  String wechatAliasname,
    		HttpServletRequest request,HttpServletResponse response) throws Exception, RuntimeException, IOException{
      
		 
	    WechatMember wechatMember = new WechatMember(wechatAliasname);
	    
	    List<WechatMember> listExcel = wechatMemberService.getWechatMemberList(wechatMember);
	    
	    
		String fileName="会员信息";
        //填充实体类实体数据
		List<WechatMember> projects= listExcel;
        List<Map<String,Object>> list=createExcelRecord(projects);
        String columnNames[]={"会员编号","注册时间","OpenID","会员昵称","所在省","所在市"};//列名
        String keys[]    =     {"memberId","memberTime","openId","wechatAliasname","regionProvName","regionCityName"};//map中的key
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ExcelUtil.createWorkBook(list,keys,columnNames).write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String((fileName + ".xls").getBytes(), "iso-8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }
	
    private List<Map<String, Object>> createExcelRecord(List<WechatMember> projects) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        WechatMember project=null;
        for (int j = 0; j < projects.size(); j++) {
            project=projects.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
	            mapValue.put("memberId", project.getMemberId());
	            mapValue.put("memberTime", project.getMemberTime());
	            mapValue.put("openId", project.getOpenId());
	            mapValue.put("wechatAliasname", project.getWechatAliasname());
	            mapValue.put("regionProvName", project.getRegionProvName());
	            mapValue.put("regionCityName", project.getRegionCityName());
            listmap.add(mapValue);
        }
        return listmap;
    
    }
	
}
