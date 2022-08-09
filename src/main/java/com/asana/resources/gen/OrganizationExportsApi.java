/*
 * Asana
 * This is the interface for interacting with the [Asana Platform](https://developers.asana.com). Our API reference is generated from our [OpenAPI spec] (https://raw.githubusercontent.com/Asana/developer-docs/master/defs/asana_oas.yaml).
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package com.asana.resources.gen;

import com.asana.ApiCallback;
import com.asana.ApiClient;
import com.asana.ApiException;
import com.asana.ApiResponse;
import com.asana.Configuration;
import com.asana.Pair;
import com.asana.ProgressRequestBody;
import com.asana.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import com.asana.models.gen.ErrorResponse;
import com.asana.models.gen.InlineResponse2012;
import com.asana.models.gen.OrganizationExportsBody;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizationExportsApi {
    private ApiClient apiClient;

    public OrganizationExportsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public OrganizationExportsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for createOrganizationExport
     * @param body The organization to export. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call createOrganizationExportCall(OrganizationExportsBody body, Boolean optPretty, List<String> optFields, Integer limit, String offset, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;
        
        // create path and map variables
        String localVarPath = "/organization_exports";

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (optPretty != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("opt_pretty", optPretty));
        if (optFields != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "opt_fields", optFields));
        if (limit != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("limit", limit));
        if (offset != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("offset", offset));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2", "personalAccessToken" };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call createOrganizationExportValidateBeforeCall(OrganizationExportsBody body, Boolean optPretty, List<String> optFields, Integer limit, String offset, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling createOrganizationExport(Async)");
        }
        
        com.squareup.okhttp.Call call = createOrganizationExportCall(body, optPretty, optFields, limit, offset, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Create an organization export request
     * This method creates a request to export an Organization. Asana will complete the export at some point after you create the request.
     * @param body The organization to export. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @return InlineResponse2012
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2012 createOrganizationExport(OrganizationExportsBody body, Boolean optPretty, List<String> optFields, Integer limit, String offset) throws ApiException {
        ApiResponse<InlineResponse2012> resp = createOrganizationExportWithHttpInfo(body, optPretty, optFields, limit, offset);
        return resp.getData();
    }

    /**
     * Create an organization export request
     * This method creates a request to export an Organization. Asana will complete the export at some point after you create the request.
     * @param body The organization to export. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @return ApiResponse&lt;InlineResponse2012&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2012> createOrganizationExportWithHttpInfo(OrganizationExportsBody body, Boolean optPretty, List<String> optFields, Integer limit, String offset) throws ApiException {
        com.squareup.okhttp.Call call = createOrganizationExportValidateBeforeCall(body, optPretty, optFields, limit, offset, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create an organization export request (asynchronously)
     * This method creates a request to export an Organization. Asana will complete the export at some point after you create the request.
     * @param body The organization to export. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param limit Results per page. The number of objects to return per page. The value must be between 1 and 100. (optional)
     * @param offset Offset token. An offset to the next page returned by the API. A pagination request will return an offset token, which can be used as an input parameter to the next request. If an offset is not passed in, the API will return the first page of results. &#x27;Note: You can only pass in an offset that was returned to you via a previously paginated request.&#x27; (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call createOrganizationExportAsync(OrganizationExportsBody body, Boolean optPretty, List<String> optFields, Integer limit, String offset, final ApiCallback<InlineResponse2012> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = createOrganizationExportValidateBeforeCall(body, optPretty, optFields, limit, offset, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getOrganizationExport
     * @param organizationExportGid Globally unique identifier for the organization export. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getOrganizationExportCall(String organizationExportGid, Boolean optPretty, List<String> optFields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/organization_exports/{organization_export_gid}"
            .replaceAll("\\{" + "organization_export_gid" + "\\}", apiClient.escapeString(organizationExportGid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (optPretty != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("opt_pretty", optPretty));
        if (optFields != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "opt_fields", optFields));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "oauth2", "personalAccessToken" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    
    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getOrganizationExportValidateBeforeCall(String organizationExportGid, Boolean optPretty, List<String> optFields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'organizationExportGid' is set
        if (organizationExportGid == null) {
            throw new ApiException("Missing the required parameter 'organizationExportGid' when calling getOrganizationExport(Async)");
        }
        
        com.squareup.okhttp.Call call = getOrganizationExportCall(organizationExportGid, optPretty, optFields, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get details on an org export request
     * Returns details of a previously-requested Organization export.
     * @param organizationExportGid Globally unique identifier for the organization export. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @return InlineResponse2012
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse2012 getOrganizationExport(String organizationExportGid, Boolean optPretty, List<String> optFields) throws ApiException {
        ApiResponse<InlineResponse2012> resp = getOrganizationExportWithHttpInfo(organizationExportGid, optPretty, optFields);
        return resp.getData();
    }

    /**
     * Get details on an org export request
     * Returns details of a previously-requested Organization export.
     * @param organizationExportGid Globally unique identifier for the organization export. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @return ApiResponse&lt;InlineResponse2012&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse2012> getOrganizationExportWithHttpInfo(String organizationExportGid, Boolean optPretty, List<String> optFields) throws ApiException {
        com.squareup.okhttp.Call call = getOrganizationExportValidateBeforeCall(organizationExportGid, optPretty, optFields, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get details on an org export request (asynchronously)
     * Returns details of a previously-requested Organization export.
     * @param organizationExportGid Globally unique identifier for the organization export. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getOrganizationExportAsync(String organizationExportGid, Boolean optPretty, List<String> optFields, final ApiCallback<InlineResponse2012> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getOrganizationExportValidateBeforeCall(organizationExportGid, optPretty, optFields, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse2012>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
