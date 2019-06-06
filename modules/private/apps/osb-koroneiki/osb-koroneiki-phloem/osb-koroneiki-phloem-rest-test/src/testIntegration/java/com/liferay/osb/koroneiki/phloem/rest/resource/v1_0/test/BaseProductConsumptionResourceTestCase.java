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

import com.liferay.osb.koroneiki.phloem.rest.client.dto.v1_0.ProductConsumption;
import com.liferay.osb.koroneiki.phloem.rest.client.http.HttpInvoker;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Page;
import com.liferay.osb.koroneiki.phloem.rest.client.pagination.Pagination;
import com.liferay.osb.koroneiki.phloem.rest.client.resource.v1_0.ProductConsumptionResource;
import com.liferay.osb.koroneiki.phloem.rest.client.serdes.v1_0.ProductConsumptionSerDes;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
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
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

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
public abstract class BaseProductConsumptionResourceTestCase {

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
		testLocale = LocaleUtil.getDefault();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_productConsumptionResource.setContextCompany(testCompany);
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

		ProductConsumption productConsumption1 = randomProductConsumption();

		String json = objectMapper.writeValueAsString(productConsumption1);

		ProductConsumption productConsumption2 = ProductConsumptionSerDes.toDTO(
			json);

		Assert.assertTrue(equals(productConsumption1, productConsumption2));
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

		ProductConsumption productConsumption = randomProductConsumption();

		String json1 = objectMapper.writeValueAsString(productConsumption);
		String json2 = ProductConsumptionSerDes.toJSON(productConsumption);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		ProductConsumption productConsumption = randomProductConsumption();

		String json = ProductConsumptionSerDes.toJSON(productConsumption);

		Assert.assertFalse(json.contains(regex));

		productConsumption = ProductConsumptionSerDes.toDTO(json);
	}

	@Test
	public void testDeleteAccountProductConsumption() throws Exception {
		ProductConsumption productConsumption =
			testDeleteAccountProductConsumption_addProductConsumption();

		assertHttpResponseStatusCode(
			204,
			ProductConsumptionResource.
				deleteAccountProductConsumptionHttpResponse(null, null));
	}

	protected ProductConsumption
			testDeleteAccountProductConsumption_addProductConsumption()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetAccountProductConsumptionsPage() throws Exception {
		Long accountId = testGetAccountProductConsumptionsPage_getAccountId();
		Long irrelevantAccountId =
			testGetAccountProductConsumptionsPage_getIrrelevantAccountId();

		if ((irrelevantAccountId != null)) {
			ProductConsumption irrelevantProductConsumption =
				testGetAccountProductConsumptionsPage_addProductConsumption(
					irrelevantAccountId, randomIrrelevantProductConsumption());

			Page<ProductConsumption> page =
				ProductConsumptionResource.getAccountProductConsumptionsPage(
					irrelevantAccountId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantProductConsumption),
				(List<ProductConsumption>)page.getItems());
			assertValid(page);
		}

		ProductConsumption productConsumption1 =
			testGetAccountProductConsumptionsPage_addProductConsumption(
				accountId, randomProductConsumption());

		ProductConsumption productConsumption2 =
			testGetAccountProductConsumptionsPage_addProductConsumption(
				accountId, randomProductConsumption());

		Page<ProductConsumption> page =
			ProductConsumptionResource.getAccountProductConsumptionsPage(
				accountId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(productConsumption1, productConsumption2),
			(List<ProductConsumption>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetAccountProductConsumptionsPageWithPagination()
		throws Exception {

		Long accountId = testGetAccountProductConsumptionsPage_getAccountId();

		ProductConsumption productConsumption1 =
			testGetAccountProductConsumptionsPage_addProductConsumption(
				accountId, randomProductConsumption());

		ProductConsumption productConsumption2 =
			testGetAccountProductConsumptionsPage_addProductConsumption(
				accountId, randomProductConsumption());

		ProductConsumption productConsumption3 =
			testGetAccountProductConsumptionsPage_addProductConsumption(
				accountId, randomProductConsumption());

		Page<ProductConsumption> page1 =
			ProductConsumptionResource.getAccountProductConsumptionsPage(
				accountId, Pagination.of(1, 2));

		List<ProductConsumption> productConsumptions1 =
			(List<ProductConsumption>)page1.getItems();

		Assert.assertEquals(
			productConsumptions1.toString(), 2, productConsumptions1.size());

		Page<ProductConsumption> page2 =
			ProductConsumptionResource.getAccountProductConsumptionsPage(
				accountId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ProductConsumption> productConsumptions2 =
			(List<ProductConsumption>)page2.getItems();

		Assert.assertEquals(
			productConsumptions2.toString(), 1, productConsumptions2.size());

		Page<ProductConsumption> page3 =
			ProductConsumptionResource.getAccountProductConsumptionsPage(
				accountId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(
				productConsumption1, productConsumption2, productConsumption3),
			(List<ProductConsumption>)page3.getItems());
	}

	protected ProductConsumption
			testGetAccountProductConsumptionsPage_addProductConsumption(
				Long accountId, ProductConsumption productConsumption)
		throws Exception {

		return ProductConsumptionResource.postAccountProductConsumption(
			accountId, productConsumption);
	}

	protected Long testGetAccountProductConsumptionsPage_getAccountId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetAccountProductConsumptionsPage_getIrrelevantAccountId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostAccountProductConsumption() throws Exception {
		ProductConsumption randomProductConsumption =
			randomProductConsumption();

		ProductConsumption postProductConsumption =
			testPostAccountProductConsumption_addProductConsumption(
				randomProductConsumption);

		assertEquals(randomProductConsumption, postProductConsumption);
		assertValid(postProductConsumption);
	}

	protected ProductConsumption
			testPostAccountProductConsumption_addProductConsumption(
				ProductConsumption productConsumption)
		throws Exception {

		return ProductConsumptionResource.postAccountProductConsumption(
			testGetAccountProductConsumptionsPage_getAccountId(),
			productConsumption);
	}

	@Test
	public void testDeleteProductConsumption() throws Exception {
		ProductConsumption productConsumption =
			testDeleteProductConsumption_addProductConsumption();

		assertHttpResponseStatusCode(
			204,
			ProductConsumptionResource.deleteProductConsumptionHttpResponse(
				productConsumption.getId()));

		assertHttpResponseStatusCode(
			404,
			ProductConsumptionResource.getProductConsumptionHttpResponse(
				productConsumption.getId()));

		assertHttpResponseStatusCode(
			404,
			ProductConsumptionResource.getProductConsumptionHttpResponse(0L));
	}

	protected ProductConsumption
			testDeleteProductConsumption_addProductConsumption()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetProductConsumption() throws Exception {
		ProductConsumption postProductConsumption =
			testGetProductConsumption_addProductConsumption();

		ProductConsumption getProductConsumption =
			ProductConsumptionResource.getProductConsumption(
				postProductConsumption.getId());

		assertEquals(postProductConsumption, getProductConsumption);
		assertValid(getProductConsumption);
	}

	protected ProductConsumption
			testGetProductConsumption_addProductConsumption()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteProjectProductConsumption() throws Exception {
		ProductConsumption productConsumption =
			testDeleteProjectProductConsumption_addProductConsumption();

		assertHttpResponseStatusCode(
			204,
			ProductConsumptionResource.
				deleteProjectProductConsumptionHttpResponse(null, null));
	}

	protected ProductConsumption
			testDeleteProjectProductConsumption_addProductConsumption()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGetProjectProductConsumptionsPage() throws Exception {
		Long projectId = testGetProjectProductConsumptionsPage_getProjectId();
		Long irrelevantProjectId =
			testGetProjectProductConsumptionsPage_getIrrelevantProjectId();

		if ((irrelevantProjectId != null)) {
			ProductConsumption irrelevantProductConsumption =
				testGetProjectProductConsumptionsPage_addProductConsumption(
					irrelevantProjectId, randomIrrelevantProductConsumption());

			Page<ProductConsumption> page =
				ProductConsumptionResource.getProjectProductConsumptionsPage(
					irrelevantProjectId, Pagination.of(1, 2));

			Assert.assertEquals(1, page.getTotalCount());

			assertEquals(
				Arrays.asList(irrelevantProductConsumption),
				(List<ProductConsumption>)page.getItems());
			assertValid(page);
		}

		ProductConsumption productConsumption1 =
			testGetProjectProductConsumptionsPage_addProductConsumption(
				projectId, randomProductConsumption());

		ProductConsumption productConsumption2 =
			testGetProjectProductConsumptionsPage_addProductConsumption(
				projectId, randomProductConsumption());

		Page<ProductConsumption> page =
			ProductConsumptionResource.getProjectProductConsumptionsPage(
				projectId, Pagination.of(1, 2));

		Assert.assertEquals(2, page.getTotalCount());

		assertEqualsIgnoringOrder(
			Arrays.asList(productConsumption1, productConsumption2),
			(List<ProductConsumption>)page.getItems());
		assertValid(page);
	}

	@Test
	public void testGetProjectProductConsumptionsPageWithPagination()
		throws Exception {

		Long projectId = testGetProjectProductConsumptionsPage_getProjectId();

		ProductConsumption productConsumption1 =
			testGetProjectProductConsumptionsPage_addProductConsumption(
				projectId, randomProductConsumption());

		ProductConsumption productConsumption2 =
			testGetProjectProductConsumptionsPage_addProductConsumption(
				projectId, randomProductConsumption());

		ProductConsumption productConsumption3 =
			testGetProjectProductConsumptionsPage_addProductConsumption(
				projectId, randomProductConsumption());

		Page<ProductConsumption> page1 =
			ProductConsumptionResource.getProjectProductConsumptionsPage(
				projectId, Pagination.of(1, 2));

		List<ProductConsumption> productConsumptions1 =
			(List<ProductConsumption>)page1.getItems();

		Assert.assertEquals(
			productConsumptions1.toString(), 2, productConsumptions1.size());

		Page<ProductConsumption> page2 =
			ProductConsumptionResource.getProjectProductConsumptionsPage(
				projectId, Pagination.of(2, 2));

		Assert.assertEquals(3, page2.getTotalCount());

		List<ProductConsumption> productConsumptions2 =
			(List<ProductConsumption>)page2.getItems();

		Assert.assertEquals(
			productConsumptions2.toString(), 1, productConsumptions2.size());

		Page<ProductConsumption> page3 =
			ProductConsumptionResource.getProjectProductConsumptionsPage(
				projectId, Pagination.of(1, 3));

		assertEqualsIgnoringOrder(
			Arrays.asList(
				productConsumption1, productConsumption2, productConsumption3),
			(List<ProductConsumption>)page3.getItems());
	}

	protected ProductConsumption
			testGetProjectProductConsumptionsPage_addProductConsumption(
				Long projectId, ProductConsumption productConsumption)
		throws Exception {

		return ProductConsumptionResource.postProjectProductConsumption(
			projectId, productConsumption);
	}

	protected Long testGetProjectProductConsumptionsPage_getProjectId()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected Long
			testGetProjectProductConsumptionsPage_getIrrelevantProjectId()
		throws Exception {

		return null;
	}

	@Test
	public void testPostProjectProductConsumption() throws Exception {
		ProductConsumption randomProductConsumption =
			randomProductConsumption();

		ProductConsumption postProductConsumption =
			testPostProjectProductConsumption_addProductConsumption(
				randomProductConsumption);

		assertEquals(randomProductConsumption, postProductConsumption);
		assertValid(postProductConsumption);
	}

	protected ProductConsumption
			testPostProjectProductConsumption_addProductConsumption(
				ProductConsumption productConsumption)
		throws Exception {

		return ProductConsumptionResource.postProjectProductConsumption(
			testGetProjectProductConsumptionsPage_getProjectId(),
			productConsumption);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		ProductConsumption productConsumption1,
		ProductConsumption productConsumption2) {

		Assert.assertTrue(
			productConsumption1 + " does not equal " + productConsumption2,
			equals(productConsumption1, productConsumption2));
	}

	protected void assertEquals(
		List<ProductConsumption> productConsumptions1,
		List<ProductConsumption> productConsumptions2) {

		Assert.assertEquals(
			productConsumptions1.size(), productConsumptions2.size());

		for (int i = 0; i < productConsumptions1.size(); i++) {
			ProductConsumption productConsumption1 = productConsumptions1.get(
				i);
			ProductConsumption productConsumption2 = productConsumptions2.get(
				i);

			assertEquals(productConsumption1, productConsumption2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<ProductConsumption> productConsumptions1,
		List<ProductConsumption> productConsumptions2) {

		Assert.assertEquals(
			productConsumptions1.size(), productConsumptions2.size());

		for (ProductConsumption productConsumption1 : productConsumptions1) {
			boolean contains = false;

			for (ProductConsumption productConsumption2 :
					productConsumptions2) {

				if (equals(productConsumption1, productConsumption2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				productConsumptions2 + " does not contain " +
					productConsumption1,
				contains);
		}
	}

	protected void assertValid(ProductConsumption productConsumption) {
		boolean valid = true;

		if (productConsumption.getDateCreated() == null) {
			valid = false;
		}

		if (productConsumption.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (productConsumption.getAccountId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("productId", additionalAssertFieldName)) {
				if (productConsumption.getProductId() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (productConsumption.getProjectId() == null) {
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

	protected void assertValid(Page<ProductConsumption> page) {
		boolean valid = false;

		Collection<ProductConsumption> productConsumptions = page.getItems();

		int size = productConsumptions.size();

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

	protected boolean equals(
		ProductConsumption productConsumption1,
		ProductConsumption productConsumption2) {

		if (productConsumption1 == productConsumption2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("accountId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						productConsumption1.getAccountId(),
						productConsumption2.getAccountId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("dateCreated", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						productConsumption1.getDateCreated(),
						productConsumption2.getDateCreated())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						productConsumption1.getId(),
						productConsumption2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("productId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						productConsumption1.getProductId(),
						productConsumption2.getProductId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("projectId", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						productConsumption1.getProjectId(),
						productConsumption2.getProjectId())) {

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

	protected Collection<EntityField> getEntityFields() throws Exception {
		if (!(_productConsumptionResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_productConsumptionResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField -> Objects.equals(entityField.getType(), type)
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		ProductConsumption productConsumption) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("accountId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("dateCreated")) {
			if (operator.equals("between")) {
				sb = new StringBundler();

				sb.append("(");
				sb.append(entityFieldName);
				sb.append(" gt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							productConsumption.getDateCreated(), -2)));
				sb.append(" and ");
				sb.append(entityFieldName);
				sb.append(" lt ");
				sb.append(
					_dateFormat.format(
						DateUtils.addSeconds(
							productConsumption.getDateCreated(), 2)));
				sb.append(")");
			}
			else {
				sb.append(entityFieldName);

				sb.append(" ");
				sb.append(operator);
				sb.append(" ");

				sb.append(
					_dateFormat.format(productConsumption.getDateCreated()));
			}

			return sb.toString();
		}

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("productId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("projectId")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected ProductConsumption randomProductConsumption() throws Exception {
		return new ProductConsumption() {
			{
				accountId = RandomTestUtil.randomLong();
				dateCreated = RandomTestUtil.nextDate();
				id = RandomTestUtil.randomLong();
				productId = RandomTestUtil.randomLong();
				projectId = RandomTestUtil.randomLong();
			}
		};
	}

	protected ProductConsumption randomIrrelevantProductConsumption()
		throws Exception {

		ProductConsumption randomIrrelevantProductConsumption =
			randomProductConsumption();

		return randomIrrelevantProductConsumption;
	}

	protected ProductConsumption randomPatchProductConsumption()
		throws Exception {

		return randomProductConsumption();
	}

	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;
	protected Locale testLocale;
	protected String testUserNameAndPassword = "test@liferay.com:test";

	private static final Log _log = LogFactoryUtil.getLog(
		BaseProductConsumptionResourceTestCase.class);

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
	private com.liferay.osb.koroneiki.phloem.rest.resource.v1_0.
		ProductConsumptionResource _productConsumptionResource;

}