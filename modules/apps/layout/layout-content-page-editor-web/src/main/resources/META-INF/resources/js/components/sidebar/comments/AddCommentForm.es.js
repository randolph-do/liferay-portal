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

import PropTypes from 'prop-types';
import React, {useState} from 'react';

import {addFragmentEntryLinkComment} from '../../../utils/FragmentsEditorFetchUtils.es';
import CommentForm from './CommentForm.es';
import {updateFragmentEntryLinkCommentAction} from '../../../actions/updateFragmentEntryLinkComment.es';
import useDispatch from '../../../store/hooks/useDispatch.es';

const AddCommentForm = props => {
	const [addingComment, setAddingComment] = useState(false);
	const [showButtons, setShowButtons] = useState(false);
	const [textareaContent, setTextareaContent] = useState('');
	const dispatch = useDispatch();

	const _handleCancelButtonClick = () => {
		setShowButtons(false);
		setTextareaContent('');
	};

	const _handleFormFocus = () => {
		setShowButtons(true);
	};

	const _handleCommentButtonClick = () => {
		setAddingComment(true);

		addFragmentEntryLinkComment(props.fragmentEntryLinkId, textareaContent)
			.then(response => response.json())
			.then(comment => {
				dispatch(
					updateFragmentEntryLinkCommentAction(
						props.fragmentEntryLinkId,
						comment
					)
				);

				setAddingComment(false);
				setShowButtons(false);
				setTextareaContent('');
			});
	};

	const _handleTextareaChange = content => {
		if (content) {
			setTextareaContent(content);
		}
	};

	return (
		<div className="px-3">
			<CommentForm
				id="pageEditorCommentEditor"
				loading={addingComment}
				onCancelButtonClick={_handleCancelButtonClick}
				onFormFocus={_handleFormFocus}
				onSubmitButtonClick={_handleCommentButtonClick}
				onTextareaChange={_handleTextareaChange}
				showButtons={showButtons}
				submitButtonLabel={Liferay.Language.get('comment')}
				textareaContent={textareaContent}
			/>
		</div>
	);
};

AddCommentForm.propTypes = {
	fragmentEntryLinkId: PropTypes.string.isRequired
};

export {AddCommentForm};
export default AddCommentForm;
