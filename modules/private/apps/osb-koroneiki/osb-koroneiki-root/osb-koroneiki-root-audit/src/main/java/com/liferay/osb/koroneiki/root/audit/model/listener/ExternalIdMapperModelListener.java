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

package com.liferay.osb.koroneiki.root.audit.model.listener;

import com.liferay.osb.koroneiki.root.audit.model.BaseAuditModelListener;
import com.liferay.osb.koroneiki.root.model.ExternalIdMapper;
import com.liferay.osb.koroneiki.root.service.ExternalIdMapperLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ModelListener;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Kyle Bischof
 */
@Component(immediate = true, service = ModelListener.class)
public class ExternalIdMapperModelListener
	extends BaseAuditModelListener<ExternalIdMapper> {

	@Override
	protected long getFieldClassNameId(ExternalIdMapper externalIdMapper) {
		return externalIdMapper.getClassNameId();
	}

	@Override
	protected long getFieldClassPK(ExternalIdMapper externalIdMapper) {
		return externalIdMapper.getClassPK();
	}

	@Override
	protected ExternalIdMapper getModel(long classPK) throws PortalException {
		return _externalIdMapperLocalService.getExternalIdMapper(classPK);
	}

	@Reference
	private ExternalIdMapperLocalService _externalIdMapperLocalService;

}