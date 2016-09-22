package cn.org.citycloud.zwhs.syl.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cn.org.citycloud.zwhs.syl.entity.RegionInfo;
import cn.org.citycloud.zwhs.syl.repository.RegionInfoDao;

//Spring Bean的标识.
@Component
// 类中所有public函数都纳入事务管理的标识.
@Transactional
public class RegionInfoService {
	@Autowired
	private RegionInfoDao regionInfoDao;
	
	
	
	public List<RegionInfo> getRegionProvince(){
		
		return regionInfoDao.findByRegionLevel(1);		//省默认类型是 1
	}
	
	public List<RegionInfo> getRegionCity(Integer regionCode){
		
		return regionInfoDao.findCityOrAreaRegionCode(regionCode, 2);
	}
	
	public List<RegionInfo> getRegionArea(Integer regionCode){
		
		return regionInfoDao.findCityOrAreaRegionCode(regionCode, 3);
	}
}
