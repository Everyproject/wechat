package com.github.service;

import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
/**
 * 
* <class description>
*	暂时没有功能	
* @author: elliswang
* @version: 1.0, Jan 4, 2017
 */
public interface ITextMsgService {
	public WxMpXmlOutMessage resolveMsg(WxMpXmlMessage msg);
}
