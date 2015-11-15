/*
 * The MIT License
 *
 * Copyright 2015 shinse.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package mrdshinse.petri.web.helper;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import mrdshinse.petri.web.util.JsonUtil;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Helper class of HTTP connection.
 *
 * @author mrdShinse
 */
public class HttpHelper {

    /**
     * The HTTP client
     */
    CloseableHttpClient httpClient;
    /**
     * The configuration of http connection.
     */
    RequestConfig requestConfig;
    /**
     * The charset.
     */
    Charset charset;
    /**
     * url
     */
    String url;
    /**
     * The HTTP response
     */
    CloseableHttpResponse response;

    /**
     * default constructor.
     */
    private HttpHelper() {
        this.httpClient = HttpClients.createDefault();
        this.requestConfig = getDefaultConfig();
        this.charset = Charset.defaultCharset();
    }

    /**
     * create instance with url.
     *
     * @param url url
     */
    public HttpHelper(String url) {
        this();
        this.url = url;
    }

    /**
     * execute HTTP request by GET method.
     *
     * @return this instance.
     */
    public HttpHelper executeGet() {

        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);

        try {
            this.response = httpClient.execute(httpGet);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return this;
    }

    /**
     * Judge status code.
     *
     * @param statusCd status code
     * @return is status code OK,
     */
    public boolean isSuccess(int statusCd) {
        return HttpStatus.SC_OK == this.response.getStatusLine().getStatusCode();
    }

    /**
     * Get HTTP response contents.
     *
     * @return (String)response
     */
    public String getStringResponse() {
        String retStr;
        try {
            retStr = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        } catch (IOException | ParseException ex) {
            throw new RuntimeException(ex);
        }
        return retStr;
    }

    /**
     * Get HTTP response contents.
     *
     * @param <T> type of bean
     * @param bean type class of bean
     * @return (Bean)response
     */
    public <T> T getBeanResponse(Class<T> bean) {
        return JsonUtil.transformToBean(getStringResponse(), bean);
    }

    /**
     * get default request config instance.
     *
     * @return default Request config instance.
     */
    private RequestConfig getDefaultConfig() {
        return RequestConfig.custom()
                .setConnectTimeout((int) TimeUnit.SECONDS.toMillis(10))
                .setSocketTimeout((int) TimeUnit.SECONDS.toMillis(10))
                .build();
    }
}
