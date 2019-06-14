/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.osb.koroneiki.xylem.publishing;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.MapUtil;

import java.util.Map;

/**
 * @author Amos Fong
 */
public class Message {

	public Message(String topic, JSONObject payloadJSONObject) {
		_topic = topic;
		_payloadJSONObject = payloadJSONObject;
	}

	public Message(
		String topic, Map<String, Object> attributes,
		JSONObject payloadJSONObject) {

		_topic = topic;
		_attributes = attributes;
		_payloadJSONObject = payloadJSONObject;
	}

	public Map<String, Object> getAttributes() {
		return _attributes;
	}

	public JSONObject getPayload() {
		return _payloadJSONObject;
	}

	public String getTopic() {
		return _topic;
	}

	public void setAttributes(Map<String, Object> attributes) {
		_attributes = attributes;
	}

	public void setPayload(JSONObject payloadJSONObject) {
		_payloadJSONObject = payloadJSONObject;
	}

	public void setTopic(String topic) {
		_topic = topic;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{topic=");
		sb.append(_topic);
		sb.append(", attributes=");
		sb.append(MapUtil.toString(_attributes));
		sb.append(", payload=");
		sb.append(_payloadJSONObject.toString());
		sb.append("}");

		return sb.toString();
	}

	private Map<String, Object> _attributes;
	private JSONObject _payloadJSONObject;
	private String _topic;

}