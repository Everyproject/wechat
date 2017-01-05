package com.github.handler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.config.MenuConfig;

import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

@Component
public class TextMsgHandler extends AbstractHandler {

	@Autowired
	protected WxMpService	wxMpService;



	@Override
	public WxMpXmlOutMessage handle(WxMpXmlMessage pWxMessage, Map<String, Object> pContext, WxMpService pWxMpService,
			WxSessionManager pSessionManager) throws WxErrorException {
		if ("help".equals(pWxMessage.getContent()) || "帮助".equals(pWxMessage.getContent())) {
			return WxMpXmlOutMessage.TEXT().fromUser(pWxMessage.getToUser()).toUser(pWxMessage.getFromUser())
					.content("欢迎使用帮助选项").build();
		} else if ("create".equals(pWxMessage.getContent())) {//内部测试创建菜单,权限待开放
			try {
				wxMpService.getMenuService().menuCreate(MenuConfig.getMenu());
			} catch (WxErrorException e) {
				e.printStackTrace();
			}

			return WxMpXmlOutMessage.TEXT().fromUser(pWxMessage.getToUser()).toUser(pWxMessage.getFromUser())
					.content("use create menu method").build();
		} else {
			return WxMpXmlOutMessage.TEXT().fromUser(pWxMessage.getToUser()).toUser(pWxMessage.getFromUser())
					.content("what are you 弄啥呢?\n输入不合法\n请输入help查看帮助选项").build();
		}
	}

}
