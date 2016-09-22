package cn.org.citycloud.zwhs.syl.repository;

import cn.org.citycloud.zwhs.syl.entity.WechatKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;


public interface WechatKeyDao extends JpaRepository<WechatKey, Integer>,
		JpaSpecificationExecutor<WechatKey> {
	public List<WechatKey> findByStoreId(int storeId);
	
	public WechatKey findByStoreIdAndReplyKeyword(int storeId, String replyKeyword);
	
//	public WechatKey findByStoreIdAndReplyType(int storeId,int replyType);
	
	public List<WechatKey> findByStoreIdAndReplyType(int storeId, int replyType);

}
