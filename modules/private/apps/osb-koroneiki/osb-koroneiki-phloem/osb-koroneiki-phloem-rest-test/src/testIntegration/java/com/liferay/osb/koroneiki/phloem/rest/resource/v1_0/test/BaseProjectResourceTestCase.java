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

package com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.Project;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.resource.v1_0.ProjectResource;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ProjectSerDes;
import com.liferay.petra.function.UnsafeTriConsumer;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang.time.DateUtils;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Amos Fong
 * @generated
 */
@Generated("")
public abstract class BaseProjectResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_projectResource.setContextCompany(testCompany);

		ProjectResource.Builder builder = ProjectResource.builder();

		projectResource = builder.locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Project project1 = randomProject();

		String json = objectMapper.writeValueAsString(project1);

		Project project2 = ProjectSerDes.toDTO(json);

		Assert.assertTrue(equals(project1, project2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		Project project = randomProject();

		String json1 = objectMapper.writeValueAsString(project);
		String json2 = ProjectSerDes.toJSON(project);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		Project project = randomProject();

		project.setAccountKey(regex);
		project.setCode(regex);
		project.setKey(regex);
		project.setName(regex);
		project.setNotes(regex);
		project.setSoldBy(regex);

		String json = ProjectSerDes.toJSON(project);

		Assert.assertFalse(json.contains(regex));

		project = ProjectSerDes.toDTO(json);

		Assert.assertEquals(regex, project.getAccountKey());
		Assert.assertEquals(regex, project.getCode());
		Assert.assertEquals(regex, project.getKey());
		Assert.assertEquals(regex, project.getName());
		Assert.assertEquals(regex, project.getNotes());
		Assert.assertEquals(regex, project.getSoldBy());
	}

	@Test
	public void testGetAccountAccountKeyProjectsPage() throws Exception {
		Page<Project> page = projectResource.getAccountAccountKeyProjectsPage(
			testGetAccountAccountKeyProjectsPage_getAccountKey(), null,
			Pagination.of(1, 2));

		Assert.assertEquals(0, page.getTotalCount());

		String accountKey =
			testGetAccountAccountKeyProjectsPage_getAccountKey();
		String irrelevantAccountKey =
			testGetAccountAccountKeyProjectsPage_getIrrelevantAccountKey();

		if ((irrelevantAccountKey != null)) {
			Project irrelevantProject =
				testGetAccountAccountKeyProjectsPage_addProject(
					irrelevantAccountKey, randomIrrelevantProject());

			page = projectResource.getAccountAccountKeyProjectsPage(
				irrelevantAccountKey, null, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantProject),
				(List<Project>)page.getItems());
			assertValid(page);
		}

		Project project1 = testGetAccountAccountKeyProjectsPage_addProject(
			accountKey, randomProject());

		Project project2 = testGetAccountAccountKeyProjectsPage_addProject(
			accountKey, randomProject());

		page = projectResource.getAccountAccountKeyProjectsPage(
			accountKey, null, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(project1, project2), (List<Project>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAccountAccountKeyProjectsPageWithPagination()
		throws Exception {

		String accountKey =
			testGetAccountAccountKeyProjectsPage_getAccountKey();

		Project project1 = testGetAccountAccountKeyProjectsPage_addProject(
			accountKey, randomProject());

		Project project2 = testGetAccountAccountKeyProjectsPage_addProject(
			accountKey, randomProject());

		Project project3 = testGetAccountAccountKeyProjectsPage_addProject(
			accountKey, randomProject());

		Page<Project> page1 = projectResource.getAccountAccountKeyProjectsPage(
			accountKey, null, Pagination.of(1, 2));

		List<Project> projects1 = (List<Project>)page1.getItems();

		Assert.assertEquals(projects1.toString(), 2, projects1.size());

		Page<Project> page2 = projectResource.getAccountAccountKeyProjectsPage(
			accountKey, null, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<Project> projects2 = (List<Project>)page2.getItems();

		Assert.assertEquals(projects2.toString(), 1, projects2.size());

		Page<Project> page3 = projectResource.getAccountAccountKeyProjectsPage(
			accountKey, null, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(project1, project2, project3),
			(List<Project>)page3.getItems());
	}

	protected Project testGetAccountAccountKeyProjectsPage_addProject(
			String accountKey, Project project)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String testGetAccountAccountKeyProjectsPage_getAccountKey()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected String
			testGetAccountAccountKeyProjectsPage_getIrrelevantAccountKey()
		throws Exception {

		return null;
	}

	@Test
	public void testPostAccountAccountKeyProject() throws Exception {
		Project randomProject = randomProject();

		Project postProject = testPostAccountAccountKeyProject_addProject(
			randomProject);

		assertEquals(randomProject, postProject);
		assertValid(postProject);
	}

	protected Project testPostAccountAccountKeyProject_addProject(
			Project project)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetProjectsPage() throws Exception {
		Page<Project> page = projectResource.getProjectsPage(
			RandomTestUtil.randomString(), null, Pagination.of(1, 2), null);

		Assert.assertEquals(0, page.getTotalCount());

		Project project1 = testGetProjectsPage_addProject(randomProject());

		Project project2 = testGetProjectsPage_addProject(randomProject());

		page = projectResource.getProjectsPage(
			null, null, Pagination.of(1, 2), null);

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(project1, project2), (List<Project>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetProjectsPageWithFilterDateTimeEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.DATE_TIME);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = randomProject();

		project1 = testGetProjectsPage_addProject(project1);

		for (EntityField entityField : entityFields) {
			Page<Project> page = projectResource.getProjectsPage(
				null, getFilterString(entityField, "between", project1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(project1),
				(List<Project>)page.getItems());
		}
	}

	@Test
	public void testGetProjectsPageWithFilterStringEquals() throws Exception {
		List<EntityField> entityFields = getEntityFields(
			EntityField.Type.STRING);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = testGetProjectsPage_addProject(randomProject());

		@SuppressWarnings("PMD.UnusedLocalVariable")
		Project project2 = testGetProjectsPage_addProject(randomProject());

		for (EntityField entityField : entityFields) {
			Page<Project> page = projectResource.getProjectsPage(
				null, getFilterString(entityField, "eq", project1),
				Pagination.of(1, 2), null);

			assertEquals(
				Collections.singletonList(project1),
				(List<Project>)page.getItems());
		}
	}

	@Test
	public void testGetProjectsPageWithPagination() throws Exception {
		Project project1 = testGetProjectsPage_addProject(randomProject());

		Project project2 = testGetProjectsPage_addProject(randomProject());

		Project project3 = testGetProjectsPage_addProject(randomProject());

		Page<Project> page1 = projectResource.getProjectsPage(
			null, null, Pagination.of(1, 2), null);

		List<Project> projects1 = (List<Project>)page1.getItems();

		Assert.assertEquals(projects1.toString(), 2, projects1.size());

		Page<Project> page2 = projectResource.getProjectsPage(
			null, null, Pagination.of(2, 2), null);

		Assert.assertEquals(3, page2.getTotalCount());

		List<Project> projects2 = (List<Project>)page2.getItems();

		Assert.assertEquals(projects2.toString(), 1, projects2.size());

		Page<Project> page3 = projectResource.getProjectsPage(
			null, null, Pagination.of(1, 3), null);

		assertEqualsIgnoringOrder(
			Arrays.asList(project1, project2, project3),
			(List<Project>)page3.getItems());
	}

	@Test
	public void testGetProjectsPageWithSortDateTime() throws Exception {
		testGetProjectsPageWithSort(
			EntityField.Type.DATE_TIME,
			(entityField, project1, project2) -> {
				BeanUtils.setProperty(
					project1, entityField.getName(),
					DateUtils.addMinutes(new Date(), -2));
			});
	}

	@Test
	public void testGetProjectsPageWithSortInteger() throws Exception {
		testGetProjectsPageWithSort(
			EntityField.Type.INTEGER,
			(entityField, project1, project2) -> {
				BeanUtils.setProperty(project1, entityField.getName(), 0);
				BeanUtils.setProperty(project2, entityField.getName(), 1);
			});
	}

	@Test
	public void testGetProjectsPageWithSortString() throws Exception {
		testGetProjectsPageWithSort(
			EntityField.Type.STRING,
			(entityField, project1, project2) -> {
				BeanUtils.setProperty(project1, entityField.getName(), "Aaa");
				BeanUtils.setProperty(project2, entityField.getName(), "Bbb");
			});
	}

	protected void testGetProjectsPageWithSort(
			EntityField.Type type,
			UnsafeTriConsumer<EntityField, Project, Project, Exception>
				unsafeTriConsumer)
		throws Exception {

		List<EntityField> entityFields = getEntityFields(type);

		if (entityFields.isEmpty()) {
			return;
		}

		Project project1 = randomProject();
		Project project2 = randomProject();

		for (EntityField entityField : entityFields) {
			unsafeTriConsumer.accept(entityField, project1, project2);
		}

		project1 = testGetProjectsPage_addProject(project1);

		project2 = testGetProjectsPage_addProject(project2);

		for (EntityField entityField : entityFields) {
			Page<Project> ascPage = projectResource.getProjectsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":asc");

			assertEquals(
				Arrays.asList(project1, project2),
				(List<Project>)ascPage.getItems());

			Page<Project> descPage = projectResource.getProjectsPage(
				null, null, Pagination.of(1, 2),
				entityField.getName() + ":desc");

			assertEquals(
				Arrays.asList(project2, project1),
				(List<Project>)descPage.getItems());
		}
	}

	protected Project testGetProjectsPage_addProject(Project project)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteProject() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testGetProject() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutProject() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testDeleteProjectContact() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutProjectContact() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testDeleteProjectContactContactKeyRole() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutProjectContactContactKeyRole() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testDeleteProjectTeamTeamKeyRole() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testPutProjectTeamTeamKeyRole() throws Exception {
		Assert.assertTrue(true);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(Project project1, Project project2) {
		Assert.assertTrue(
			project1 + " does not equal " + project2,
			equals(project1, project2));
	}

	protected void assertEquals(
		List<Project> projects1, List<Project> projects2) {

		Assert.assertEquals(projects1.size(), projects2.size());

		for (int i = 0; i < projects1.size(); i++) {
			Project project1 = projects1.get(i);
			Project project2 = projects2.get(i);

			assertEquals(project1, project2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<Project> projects1, List<Project> projects2) {

		Assert.assertEquals(projects1.size(), projects2.size());

		for (Project project1 : projects1) {
			boolean contains = false;

			for (Project project2 : projects2) {
				if (equals(project1, project2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				projects2 + " does not contain " + project1, contains);
		}
	}

	protected void assertValid(Project project) {
		boolean valid = true;

		if (project.getDateCreated() == null) {
			valid = false;
		}

		if (project.getDateModified() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountKey", additionalAssertFieldName)) {
				if (project.getAccountKey() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (project.getCode() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("externalLinks", additionalAssertFieldName)) {
				if (project.getExternalLinks() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("industry", additionalAssertFieldName)) {
				if (project.getIndustry() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("key", additionalAssertFieldName)) {
				if (project.getKey() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (project.getName() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("notes", additionalAssertFieldName)) {
				if (project.getNotes() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("productPurchases", additionalAssertFieldName)) {
				if (project.getProductPurchases() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("soldBy", additionalAssertFieldName)) {
				if (project.getSoldBy() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (project.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("tier", additionalAssertFieldName)) {
				if (project.getTier() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<Project> page) {
		boolean valid = false;

		java.util.Collection<Project> projects = page.getItems();

		int size = projects.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(Project project1, Project project2) {
		if (project1 == project2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountKey", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getAccountKey(), project2.getAccountKey())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("code", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getCode(), project2.getCode())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateCreated", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getDateCreated(), project2.getDateCreated())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateModified", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getDateModified(),
						project2.getDateModified())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("externalLinks", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getExternalLinks(),
						project2.getExternalLinks())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("industry", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getIndustry(), project2.getIndustry())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("key", additionalAssertFieldName)) {
				if (!Objects.deepEquals(project1.getKey(), project2.getKey())) {
					return false;
				}

				continue;
			}

			if (Objects.equals("name", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getName(), project2.getName())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("notes", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getNotes(), project2.getNotes())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("productPurchases", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getProductPurchases(),
						project2.getProductPurchases())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("soldBy", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getSoldBy(), project2.getSoldBy())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getStatus(), project2.getStatus())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("tier", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						project1.getTier(), project2.getTier())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_projectResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_projectResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, Project project) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("accountKey")) {
			sb.append("'");
			sb.append(String.valueOf(project.getAccountKey()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("code")) {
			sb.append("'");
			sb.append(String.valueOf(project.getCode()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("dateCreated")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getDateCreated(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getDateCreated(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getDateCreated()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("dateModified")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getDateModified(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(project.getDateModified(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(_dateFormat.format(project.getDateModified()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("externalLinks")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("industry")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("key")) {
			sb.append("'");
			sb.append(String.valueOf(project.getKey()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("name")) {
			sb.append("'");
			sb.append(String.valueOf(project.getName()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("notes")) {
			sb.append("'");
			sb.append(String.valueOf(project.getNotes()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("productPurchases")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("soldBy")) {
			sb.append("'");
			sb.append(String.valueOf(project.getSoldBy()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("tier")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected Project randomProject() throws Exception {
		return new Project() {
			{
				accountKey = RandomTestUtil.randomString();
				code = RandomTestUtil.randomString();
				dateCreated = RandomTestUtil.nextDate();
				dateModified = RandomTestUtil.nextDate();
				key = RandomTestUtil.randomString();
				name = RandomTestUtil.randomString();
				notes = RandomTestUtil.randomString();
				soldBy = RandomTestUtil.randomString();
			}
		};
	}

	protected Project randomIrrelevantProject() throws Exception {
		Project randomIrrelevantProject = randomProject();

		return randomIrrelevantProject;
	}

	protected Project randomPatchProject() throws Exception {
		return randomProject();
	}

	protected ProjectResource projectResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	private static final Log _log = LogFactoryUtil.getLog(
		BaseProjectResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.ProjectResource
		_projectResource;

}