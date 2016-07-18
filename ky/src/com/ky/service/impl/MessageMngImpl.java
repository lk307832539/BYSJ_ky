package com.ky.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ky.dao.MessageContentDao;
import com.ky.dao.MessageDao;
import com.ky.entity.Admin;
import com.ky.entity.Car;
import com.ky.entity.CarOwner;
import com.ky.entity.MassageContent;
import com.ky.entity.Message;
import com.ky.entity.Order;
import com.ky.entity.Tenant;
import com.ky.entity.User;
import com.ky.service.MessageMng;
import com.ky.until.TimestampFormat;

@Service
public class MessageMngImpl implements MessageMng {

	@Resource
	private MessageDao messageDao;
	@Resource
	private MessageContentDao messageContentDao;

	@Override
	public void sendOrderMessage(Car car, User user, Order order) {
		Message message = new Message();
		// 新建一个Message
		message.setUser(car.getCarOwner().getUser());
		message.setStatue(0);
		// 新建MessageContent内容
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(user);
		massageContent.setMessage(message);
		massageContent.setType("汽车租赁申请");
		String text = "<h4>用户"
				+ user.getUserName()
				+ "想租赁您的汽车"
				+ car.getCarBrand().getBrandName()
				+ car.getCarSeries().getSeriesName()
				+ "</h4></br>"
				+ "您可以通过拨打该用户的电话："
				+ user.getTenant().getPhone()
				+ "</br>来确定是否同意出租</br>"
				+ "<h4>您是否同意</h4></br>"
				+ "<a class=\"stdbtn btn_lime\" href=\"OrderAgree.do?orderid="
				+ order.getOrderId()
				+ "\">同意</a>"
				+ "<a type=\"button\"  class=\"stdbtn\" href=\"OrderDisAgree.do?orderid="
				+ order.getOrderId()+ "\">不同意</a>";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);
		// 将信息保存进数据库
		this.messageDao.addMessage(message);
		// this.messageContentDao.addMessageContent(massageContent);
	}

	@Override
	public List<Message> getUserMessage(User user) {
		List<Message> list = this.messageDao.getUserMessage(user.getUserId());
		return list;
	}

	@Override
	public Message getMessageById(Integer messageid) {
		Message message = this.messageDao.getMessageById(messageid);
		return message;
	}

	@Override
	public void sendOrderAgree(Order order, User user) {
		Message message = new Message();
		message.setUser(order.getTenant().getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(user);
		massageContent.setMessage(message);
		massageContent.setType("同意租赁申请");
		String text = "经过你和车主的协商，车主已经同意将"
				+ order.getCar().getCarBrand().getBrandName()
				+ order.getCar().getCarSeries().getSeriesName() + "租赁给你";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);

		this.messageDao.addMessage(message);
	}

	@Override
	public void sendOrderDisAgree(Order order, User user) {
		Message message = new Message();
		message.setUser(order.getTenant().getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(user);
		massageContent.setMessage(message);
		massageContent.setType("拒绝租赁申请");
		String text = "经过你和车主的协商，车主不同意将"
				+ order.getCar().getCarBrand().getBrandName()
				+ order.getCar().getCarSeries().getSeriesName()
				+ "租赁给你，此订单已经关闭";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);

		this.messageDao.addMessage(message);
	}

	//更新message状态
	@Override
	public void updateMessageStatus(Message message) {
		this.messageDao.updateMessageStatue(message);
	}

	@Override
	public void sendOrderFinish(Order order, User user) {
		Message message = new Message();
		message.setUser(order.getTenant().getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(user);
		massageContent.setMessage(message);
		massageContent.setType("订单完成通知");
		String text = "你和车主的已经完成"
				+ order.getCar().getCarBrand().getBrandName()
				+ order.getCar().getCarSeries().getSeriesName()
				+ "，此次汽车租赁。</br>"
				+ "请点击“评价”按钮对此次租赁填写您的租赁体验。<br/>"
				+ "<a class=\"stdbtn btn_lime\" href=\"apprisePage.do?orderid="
				+ order.getOrderId()
				+ "\">评价</a>";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);

		this.messageDao.addMessage(message);
		
	}

	@Override
	public void sendCarVerifyPass(Car car,Admin admin) {
		Message message = new Message();
		message.setUser(car.getCarOwner().getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(admin.getUser());
		massageContent.setMessage(message);
		massageContent.setType("审核通过通知");
		String text = "您的汽车"
				+ car.getCarBrand().getBrandName()
				+ car.getCarSeries().getSeriesName()
				+ "已经通过审核";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);

		this.messageDao.addMessage(message);
	}

	@Override
	public void sendCarVerifyDisPass(Car car, Admin admin) {
		Message message = new Message();
		message.setUser(car.getCarOwner().getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(admin.getUser());
		massageContent.setMessage(message);
		massageContent.setType("审核失败通知");
		String text = "您的汽车"
				+ car.getCarBrand().getBrandName()
				+ car.getCarSeries().getSeriesName()
				+ "没有通过审核，请修改。";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);

		this.messageDao.addMessage(message);
	}

	@Override
	public void sendvehicleLicenseVerifyDisPass(Car car, Admin admin) {
		Message message = new Message();
		message.setUser(car.getCarOwner().getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(admin.getUser());
		massageContent.setMessage(message);
		massageContent.setType("审核失败通知");
		String text = "您的汽车"
				+ car.getCarBrand().getBrandName()
				+ car.getCarSeries().getSeriesName()
				+ "行驶证没有通过审核，请修改。";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);

		this.messageDao.addMessage(message);
	}

	@Override
	public void sendcarOwnerVerifyPass(CarOwner carOwner, Admin admin) {
		Message message = new Message();
		message.setUser(carOwner.getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(admin.getUser());
		massageContent.setMessage(message);
		massageContent.setType("审核通过通知");
		String text = "车主"
				+ carOwner.getRealName()
				+ "您好，您的车主基本信息已经通过审核";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);

		this.messageDao.addMessage(message);
	}
	@Override
	public void sendcarOwnerDisVerifyPass(CarOwner carOwner, Admin admin) {
		Message message = new Message();
		message.setUser(carOwner.getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(admin.getUser());
		massageContent.setMessage(message);
		massageContent.setType("审核失败通知");
		String text = "车主"
				+ carOwner.getRealName()
				+ "您好，您的车主基本信息没有通过审核，请修改基本信息";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);
		
		this.messageDao.addMessage(message);
	}

	@Override
	public void sendTenantVerifyPass(Tenant tenant, Admin admin) {
		Message message = new Message();
		message.setUser(tenant.getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(admin.getUser());
		massageContent.setMessage(message);
		massageContent.setType("审核通过通知");
		String text = "租客"
				+ tenant.getRealName()
				+ "您好，您的租客基本信息已经通过审核";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);

		this.messageDao.addMessage(message);
	}

	@Override
	public void sendTenantVerifyDisPass(Tenant tenant, Admin admin) {
		Message message = new Message();
		message.setUser(tenant.getUser());
		message.setStatue(0);
		MassageContent massageContent = new MassageContent();
		massageContent.setUser(admin.getUser());
		massageContent.setMessage(message);
		massageContent.setType("审核失败通知");
		String text = "租客"
				+ tenant.getRealName()
				+ "您好，您的租客基本信息没有通过审核，请修改基本信息";
		massageContent.setMassageContent(text);
		massageContent.setPostDate(TimestampFormat.TimestampToDate(new Date()));
		message.setMassageContents(massageContent);

		this.messageDao.addMessage(message);
	}


}
