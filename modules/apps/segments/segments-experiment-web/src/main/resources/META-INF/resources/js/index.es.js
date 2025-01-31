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
import ReactDOM from 'react-dom';
import {ClayIconSpriteContext} from '@clayui/icon';
import SegmentsExperimentsSidebar from './components/SegmentsExperimentsSidebar.es';
import SegmentsExperimentsContext from './context.es';

export default function segmentsExperimentsApp(id, props, context) {
	const rootElement = document.getElementById(id);

	ReactDOM.render(
		<SegmentsExperimentsContext.Provider
			value={{
				contentPageEditorNamespace: context.contentPageEditorNamespace,
				endpoints: context.endpoints,
				namespace: context.namespace,
				page: context.page
			}}
		>
			<ClayIconSpriteContext.Provider value={context.spritemap}>
				<SegmentsExperimentsSidebar
					initialGoals={props.segmentsExperimentGoals}
					initialSegmentsExperiences={props.segmentsExperiences}
					initialSegmentsExperiment={props.segmentsExperiment}
					initialSegmentsVariants={props.initialSegmentsVariants}
					initialSelectedSegmentsExperienceId={
						props.selectedSegmentsExperienceId
					}
				/>
			</ClayIconSpriteContext.Provider>
		</SegmentsExperimentsContext.Provider>,
		rootElement
	);

	Liferay.once('destroyPortlet', () =>
		ReactDOM.unmountComponentAtNode(rootElement)
	);
}
