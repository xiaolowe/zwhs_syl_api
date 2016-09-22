package cn.org.citycloud.zwhs.syl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import cn.org.citycloud.zwhs.syl.entity.WechatMember;

import java.lang.Integer;


/**
 * 
 * @author Allen
 *
 */
public interface WechatMemberDao extends PagingAndSortingRepository<WechatMember, Integer> , JpaRepository<WechatMember, Integer>, JpaSpecificationExecutor<WechatMember> {

	
	/**
	 * 根据会员id查找会员信息
	 * @param storeId
	 * @return
	 */
	@Query(value = "SELECT * FROM wechat_member s WHERE s.member_id = ?1", nativeQuery = true)
	public WechatMember findWechatMemberByMemberId(Integer memberId);
	
}
