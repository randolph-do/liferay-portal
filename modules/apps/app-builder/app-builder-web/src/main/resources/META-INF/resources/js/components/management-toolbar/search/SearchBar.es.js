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

import React from 'react';
import SearchInput from './SearchInput.es';
import SearchSort from './SearchSort.es';

export default ({columns}) => {
	return (
		<div className="navbar-form navbar-form-autofit navbar-overlay navbar-overlay-sm-down">
			<div className="container-fluid container-fluid-max-xl">
				<SearchSort columns={columns} />
				<SearchInput />
			</div>
		</div>
	);
};
