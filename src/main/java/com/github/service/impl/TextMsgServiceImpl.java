package com.github.service.impl;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.service.CoreService;
import com.github.service.ITextMsgService;
@Service
public class TextMsgServiceImpl implements ITextMsgService{
	@Autowired
    protected CoreService coreService;
	@Override
	public WxMpXmlOutMessage resolveMsg(WxMpXmlMessage pMsg) {
		String content = pMsg.getContent();
		WxMpXmlOutMessage outMessage = this.coreService.route(pMsg);
		if("help".equals(content) || "帮助".equals(content)){
		}else{
			outMessage = WxMpXmlOutMessage.TEXT().content("弄啥呢").build();
		}
		return outMessage;
	}

}
