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
import com.asana.models.gen.InlineResponse20041;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTaskListsApi {
    private ApiClient apiClient;

    public UserTaskListsApi() {
        this(Configuration.getDefaultApiClient());
    }

    public UserTaskListsApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for getUserTaskList
     * @param userTaskListGid Globally unique identifier for the user task list. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getUserTaskListCall(String userTaskListGid, Boolean optPretty, List<String> optFields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/user_task_lists/{user_task_list_gid}"
            .replaceAll("\\{" + "user_task_list_gid" + "\\}", apiClient.escapeString(userTaskListGid.toString()));

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
    private com.squareup.okhttp.Call getUserTaskListValidateBeforeCall(String userTaskListGid, Boolean optPretty, List<String> optFields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'userTaskListGid' is set
        if (userTaskListGid == null) {
            throw new ApiException("Missing the required parameter 'userTaskListGid' when calling getUserTaskList(Async)");
        }
        
        com.squareup.okhttp.Call call = getUserTaskListCall(userTaskListGid, optPretty, optFields, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a user task list
     * Returns the full record for a user task list.
     * @param userTaskListGid Globally unique identifier for the user task list. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @return InlineResponse20041
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse20041 getUserTaskList(String userTaskListGid, Boolean optPretty, List<String> optFields) throws ApiException {
        ApiResponse<InlineResponse20041> resp = getUserTaskListWithHttpInfo(userTaskListGid, optPretty, optFields);
        return resp.getData();
    }

    /**
     * Get a user task list
     * Returns the full record for a user task list.
     * @param userTaskListGid Globally unique identifier for the user task list. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @return ApiResponse&lt;InlineResponse20041&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse20041> getUserTaskListWithHttpInfo(String userTaskListGid, Boolean optPretty, List<String> optFields) throws ApiException {
        com.squareup.okhttp.Call call = getUserTaskListValidateBeforeCall(userTaskListGid, optPretty, optFields, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse20041>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a user task list (asynchronously)
     * Returns the full record for a user task list.
     * @param userTaskListGid Globally unique identifier for the user task list. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUserTaskListAsync(String userTaskListGid, Boolean optPretty, List<String> optFields, final ApiCallback<InlineResponse20041> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getUserTaskListValidateBeforeCall(userTaskListGid, optPretty, optFields, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse20041>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for getUserTaskListForUser
     * @param userGid A string identifying a user. This can either be the string \&quot;me\&quot;, an email, or the gid of a user. (required)
     * @param workspace The workspace in which to get the user task list. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getUserTaskListForUserCall(String userGid, String workspace, Boolean optPretty, List<String> optFields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // create path and map variables
        String localVarPath = "/users/{user_gid}/user_task_list"
            .replaceAll("\\{" + "user_gid" + "\\}", apiClient.escapeString(userGid.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        if (optPretty != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("opt_pretty", optPretty));
        if (optFields != null)
        localVarCollectionQueryParams.addAll(apiClient.parameterToPairs("csv", "opt_fields", optFields));
        if (workspace != null)
        localVarQueryParams.addAll(apiClient.parameterToPair("workspace", workspace));

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
    private com.squareup.okhttp.Call getUserTaskListForUserValidateBeforeCall(String userGid, String workspace, Boolean optPretty, List<String> optFields, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        // verify the required parameter 'userGid' is set
        if (userGid == null) {
            throw new ApiException("Missing the required parameter 'userGid' when calling getUserTaskListForUser(Async)");
        }
        // verify the required parameter 'workspace' is set
        if (workspace == null) {
            throw new ApiException("Missing the required parameter 'workspace' when calling getUserTaskListForUser(Async)");
        }
        
        com.squareup.okhttp.Call call = getUserTaskListForUserCall(userGid, workspace, optPretty, optFields, progressListener, progressRequestListener);
        return call;

        
        
        
        
    }

    /**
     * Get a user&#x27;s task list
     * Returns the full record for a user&#x27;s task list.
     * @param userGid A string identifying a user. This can either be the string \&quot;me\&quot;, an email, or the gid of a user. (required)
     * @param workspace The workspace in which to get the user task list. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @return InlineResponse20041
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public InlineResponse20041 getUserTaskListForUser(String userGid, String workspace, Boolean optPretty, List<String> optFields) throws ApiException {
        ApiResponse<InlineResponse20041> resp = getUserTaskListForUserWithHttpInfo(userGid, workspace, optPretty, optFields);
        return resp.getData();
    }

    /**
     * Get a user&#x27;s task list
     * Returns the full record for a user&#x27;s task list.
     * @param userGid A string identifying a user. This can either be the string \&quot;me\&quot;, an email, or the gid of a user. (required)
     * @param workspace The workspace in which to get the user task list. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @return ApiResponse&lt;InlineResponse20041&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<InlineResponse20041> getUserTaskListForUserWithHttpInfo(String userGid, String workspace, Boolean optPretty, List<String> optFields) throws ApiException {
        com.squareup.okhttp.Call call = getUserTaskListForUserValidateBeforeCall(userGid, workspace, optPretty, optFields, null, null);
        Type localVarReturnType = new TypeToken<InlineResponse20041>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get a user&#x27;s task list (asynchronously)
     * Returns the full record for a user&#x27;s task list.
     * @param userGid A string identifying a user. This can either be the string \&quot;me\&quot;, an email, or the gid of a user. (required)
     * @param workspace The workspace in which to get the user task list. (required)
     * @param optPretty Provides “pretty” output. Provides the response in a “pretty” format. In the case of JSON this means doing proper line breaking and indentation to make it readable. This will take extra time and increase the response size so it is advisable only to use this during debugging. (optional)
     * @param optFields Defines fields to return. Some requests return *compact* representations of objects in order to conserve resources and complete the request more efficiently. Other times requests return more information than you may need. This option allows you to list the exact set of fields that the API should be sure to return for the objects. The field names should be provided as paths, described below. The id of included objects will always be returned, regardless of the field options. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getUserTaskListForUserAsync(String userGid, String workspace, Boolean optPretty, List<String> optFields, final ApiCallback<InlineResponse20041> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getUserTaskListForUserValidateBeforeCall(userGid, workspace, optPretty, optFields, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<InlineResponse20041>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
