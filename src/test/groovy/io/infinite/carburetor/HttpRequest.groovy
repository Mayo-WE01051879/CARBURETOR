package io.infinite.carburetor


import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, includeSuper = true)
//@compilestatic
class HttpRequest extends HttpMessageAbstract {

    String method
    String url
    String requestStatus
    String exceptionString
    final Date sendDate = new Date()
    Map<String, Object> httpProperties = new HashMap<>()
    Map<String, Object> extensions = new HashMap<>()

}
