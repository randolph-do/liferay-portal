/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.jenkins.results.parser;

/**
 * @author Michael Hashimoto
 */
public class K8sNodeReadWriteResourceMonitor
	extends BaseReadWriteResourceMonitor {

	public K8sNodeReadWriteResourceMonitor(
		String etcdServerURL, String k8sNodeName) {

		super(
			etcdServerURL, "k8s_node_" + k8sNodeName,
			_ALLOWED_RESOURCE_CONNECTIONS);
	}

	private static final int _ALLOWED_RESOURCE_CONNECTIONS = 5;

}