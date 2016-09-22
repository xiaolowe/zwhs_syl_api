package cn.org.citycloud.zwhs.syl.controller;

import cn.org.citycloud.zwhs.syl.bean.RetailMemberBean;
import cn.org.citycloud.zwhs.syl.bean.RetailMemberSearch;
import cn.org.citycloud.zwhs.syl.bean.RetailShopBean;
import cn.org.citycloud.zwhs.syl.bean.RetailShopSearch;
import cn.org.citycloud.zwhs.syl.exception.BusinessErrorException;
import cn.org.citycloud.zwhs.syl.service.RetailMemberService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

/**
 * desc the file.
 *
 * @author demon
 * @Date 2016/7/26 10:35
 */
@RestController
@Api(tags = "分销会员管理")
@RequestMapping("/retail")
public class RetailMemberController {

    @Autowired
    private RetailMemberService memberService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value="获取分销会员列表",notes="获取分销会员列表",consumes="application/json",produces="application/json")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="pageNo",value="页数",dataType="int",paramType="query"),
            @ApiImplicitParam(name="pageSize",value="每页大小",dataType="int",paramType="query"),
            @ApiImplicitParam(name="startTime",value="开始时间",dataType="string",paramType="query"),
            @ApiImplicitParam(name="endTime",value="截止时间",dataType="string",paramType="query"),
            @ApiImplicitParam(name="memberState",value="分销会员状态（0 待审核   1  已审核   2  冻结）",dataType="int",paramType="query"),
            @ApiImplicitParam(name="memberTruename",value="会员名称",dataType="string",paramType="query"),
            @ApiImplicitParam(name="memberId",value="会员Id",dataType="string",paramType="query")
    })
    public Object findMemberList(@ApiIgnore RetailMemberSearch search) {
        return memberService.findPage(search);
    }

    @RequestMapping(value="/{memberId}",method=RequestMethod.GET)
    @ApiOperation(value="获取会员详情",notes="获取会员详情",consumes="application/json",produces="application/json",httpMethod="GET")
    public Object findMemberDetail(@ApiParam(name="memberId",value="会员id",required=true) @PathVariable int memberId) {
        return memberService.findMemberDetail(memberId);
    }

    @RequestMapping(value="/{memberId}/pass",method=RequestMethod.PUT)
    @ApiOperation(value="会员审核通过",notes="会员审核通过",consumes="application/json",produces="application/json",httpMethod="PUT")
    public Object passMember(@ApiParam(name="memberId",value="会员id",required=true) @PathVariable int memberId) {
        return memberService.passMember(memberId);
    }

    @RequestMapping(value="/{memberId}/rejected",method=RequestMethod.PUT)
    @ApiOperation(value="会员审核驳回",notes="会员审核驳回",consumes="application/json",produces="application/json",httpMethod="PUT")
    public Object rejectedMember(@ApiParam(name="memberId",value="会员id",required=true) @PathVariable int memberId) {
        return memberService.rejectedMember(memberId);
    }

    @RequestMapping(value="/{memberId}",method=RequestMethod.PUT)
    @ApiOperation(value="修改会员信息",notes="修改会员信息",consumes="application/json",produces="application/json",httpMethod="PUT")
    public Object updateMember(@RequestBody @Valid RetailMemberBean bean, @ApiParam(name="memberId",value="会员id",required=true) @PathVariable int memberId) throws BusinessErrorException {
        return memberService.updateMember(bean, memberId);
    }

    @RequestMapping(value="/{memberId}/shop",method=RequestMethod.GET)
    @ApiOperation(value="获取会员店铺详情",notes="获取会员店铺详情",consumes="application/json",produces="application/json",httpMethod="GET")
    public Object findMemberShop(@ApiParam(name="memberId",value="会员id",required=true) @PathVariable int memberId) {
        return memberService.findMemberShop(memberId);
    }

    @RequestMapping(value="/shop/{shopId}",method=RequestMethod.PUT)
    @ApiOperation(value="修改会员店铺信息",notes="修改会员店铺信息",consumes="application/json",produces="application/json",httpMethod="PUT")
    public Object updateMemberShop(@RequestBody @Valid RetailShopBean shopBean, @ApiParam(name="shopId",value="店铺Id",required=true) @PathVariable int shopId) {
        return memberService.updateMemberShop(shopBean, shopId);
    }

    @RequestMapping(value = "/shop/goods", method = RequestMethod.GET)
    @ApiOperation(value="获取分销会员商品列表",notes="获取分销会员商品列表",consumes="application/json",produces="application/json")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="pageNo",value="页数",dataType="int",paramType="query"),
            @ApiImplicitParam(name="pageSize",value="每页大小",dataType="int",paramType="query"),
            @ApiImplicitParam(name="goodsName",value="商品名称",dataType="string",paramType="query"),
            @ApiImplicitParam(name="memberId",value="会员Id",dataType="int",paramType="query")
    })
    public Object findShopGoodsByPage(RetailShopSearch search) {
        return memberService.findShopGoodsByPage(search);
    }

    @RequestMapping(value="/{goodsId}/unshelved",method=RequestMethod.PUT)
    @ApiOperation(value="分销商品下架",notes="分销商品下架",consumes="application/json",produces="application/json",httpMethod="PUT")
    public Object unshelved(@ApiParam(name="goodsId",value="商品Id",required=true) @PathVariable int goodsId) {
        return memberService.unshelved(goodsId);
    }

}
