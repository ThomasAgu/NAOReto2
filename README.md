# NAOReto2
documentation of Scopus Search API


## Descripcion 

Scopus Search API es una interfaz de programación de aplicaciones (API) proporcionada por Elsevier que permite a los usuarios realizar búsquedas avanzadas en la base de datos de Scopus, que contiene más de 80 millones de registros de artículos de revistas, libros, conferencias, patentes y otros tipos de publicaciones científicas y técnicas.
La API permite a los desarrolladores de software integrar las capacidades de búsqueda de Scopus en sus propias aplicaciones, lo que les permite acceder a información detallada y actualizada sobre la investigación en diversas áreas temáticas. Los usuarios pueden realizar búsquedas basadas en palabras clave, títulos de publicaciones, autores, afiliaciones, nombres de revistas y otros criterios de búsqueda, y pueden filtrar los resultados por fecha de publicación, idioma, tipo de publicación, campo temático y otros criterios.


| Resource  | Method | Description   |  
|---|---|---|
|  https://api.elsevier.com/content/search/scopus |GET|  SCOPUS Search API: This represents a search against the SCOPUS cluster, which contains SCOPUS abstracts. Scopus is the largest abstract and citation database of research literature and quality web sources. Updated daily, Scopus covers 50 million abstracts of over 20,500 peer-reviewed titles from more than 5,000 publishers. This search resource allows for the submission of Boolean queries into the Scopus index, retrieving relevant result metadata in a user-specific text formats. | 



### Methods

## GET ##

Si bien el metodo es simple podemos modificarlo tanto por los header al pedir el metodo como tambien en los parametros de la query

#### Header Params 
| Nombre  |  Tipo de dato |  Descripcion |   
|---|---|---|
| Accept  |  xsd:string (required) default: application/json options: application/json, application/atom+xml, application/xml | This represents the acceptable mime type format in which the response can be generated. This can also be submitted as the query string parameter "httpAccept". This returns the response in JSON, ATOM, or XML mark-up.  | 
| Authorization  |  xsd:string	 | This header field contains the OAuth bearer access token in which the format of the field is "Bearer <token>" (where the token represents the end-user session key). The presence of a bearer token implies the request will be executed against user-based entitlements. The Authorization field overrides X-ELS-Authtoken.  |   
|  X-ELS-APIKey | xsd:string	(obligatoria)  |  This represents a unique application developer key providing access to API resources. This key can also be submitted as the query string parameter "apiKey" |  
| X-ELS-Authtoken	  | xsd:string	  |  This represents a unique application developer key providing access to API resources. This key can also be submitted as the query string parameter "apiKey" |  
| X-ELS-Insttoken	  | xsd:string	  |  This represents a institution token. If provided, this key (in combination with its associated APIKey) is used to establish the credentials needed to access content in this resource. This token can also be provided through the query string parameter "insttoken". |  
| X-ELS-ReqId	  | xsd:string  |  This represents a institution token. If provided, this key (in combination with its associated APIKey) is used to establish the credentials needed to access content in this resource. This token can also be provided through the query string parameter "insttoken". |  
| X-ELS-ResourceVersion  |   | This represents a institution token. If provided, this key (in combination with its associated APIKey) is used to establish the credentials needed to access content in this resource. This token can also be provided through the query string parameter "insttoken".  |  


#### Query Params 
| Nombre  |  Tipo de dato  | Descripcion  |   
|---|---|---|
|  httpAccept |  	xsd:string options: application/json, application/atom+xml, application/xml | Override for HTTP header Accept, this represents the acceptable mime types in which the response can be generated.  |
|  access_token | xsd:string  |  Override for HTTP header Authorization, this contains the OAuth bearer access token, where the format of the field is "<token>" (where the token represents the end-user session key). The presence of a bearer token implies the request will be executed against user-based entitlements. |
|  insttoken | xsd:string  |  Override for HTTP header X-ELS-Insttoken, this represents a institution token. If provided, this key (in combination with its associated APIKey) is used to establish the credentials needed to access content in this resource. |
|  apiKey |  	xsd:string |  Override for HTTP header X-ELS-APIKey, this represents a unique application developer key providing access to resource. |
|  reqId |  	xsd:string |  Override for HTTP header X-ELS-ReqId, this is a client-defined request identifier, which will be logged in all trace messages of the service. This identifier can be used to track a specific transaction in the service's message logs. Note that this should be a unique identifier for the client, and used to track a single transaction. |
|  ver | 	xsd:string options: facetexpand, allexpand, new  | Override for HTTP header X-ELS-ResourceVersion, this represents the version of the resource that should be received. Multiple attributes can be submitted by separating with commas or semicolons. Options include: facetexpand - adds new fields under each facet returned (where applicable) allexpand - (same as facetexpand) new - returns the most recent and prototyped features  |
|  query | 	xsd:string(required)  | Override for HTTP header X-ELS-ResourceVersion, this represents the version of the resource that should be received. Multiple attributes can be submitted by separating with commas or semicolons. Options include: facetexpand - adds new fields under each facet returned (where applicable) allexpand - (same as facetexpand) new - returns the most recent and prototyped features  |
|  view | xsd:string default: STANDARD options: STANDARD, COMPLETE  | This alias represents the list of elements that will be returned in the response.   |
|  field | xsd:string  | This alias represents the name of specific fields that should be returned. The list of fields include all of the fields returned in the response payload (see view). Multiple fields can be specified, delimited by commas. Note that specifying this parameter overrides the view parameter. ex. field=url,identifier,description |
|  supressNavLinks |  xsd:string default: false options: true, false |  This parameter is used to suppress the inclusion of top-level navigation links in the response payload. |
|  date | xsd:string  |  Represents the date range associated with the search, with the lowest granularity being year. |
|  start |  xsd:string | Numeric value representing the results offset (i.e. starting position for the search results). The maximum for this value is a system-level default (varies with search cluster) minus the number of results requested. If not specified the offset will be set to zero (i.e. first search result)  |
|  count | xsd:string  |  Numeric value representing the maximum number of results to be returned for the search. If not provided this will be set to a system default based on service level. In addition the number cannot exceed the maximum system default - if it does an error will be returned. |
|  sort | xsd:string options: artnum, citedby-count, coverDate, creator, orig-load-date, pagecount, pagefirst, pageRange, publicationName, pubyear, relevancy, volume  | Represents the sort field name and order. A plus in front of the sort field name indicates ascending order, a minus indicates descending order. If sort order is not specified (i.e. no + or -) then the order defaults to descending (DESC). Up to three fields can be specified, each delimited by a comma. The precedence is determined by their order (i.e. first is primary, second is secondary, and third is tertiary)  |
|  content |  xsd:string default: all options: core, dummy, all |  This parameter is used to filter specific categories of content that should be searched/returned. |
|  subj | xsd:string  | Represents the subject area code associated with the content category desired. Note that these subject code mapping vary based upon the environment in which the request is executed.  |
|  alias |  xsd:string default: true options: true, false | This parameter controls the default behavior of returning a superseded author profiles. Submitting this parameter as false will override the default behavior. This is only applicable for searches targeting author identifiers.  |
|  cursor | xsd:string  | This parameter is used when a user wants to execute deep pagination searching (i.e. iterate to the end of a search result set).  |
|  facets | xsd:string options: af-id, aucite, au-id, authname, country, exactsrctitle, fund-sponsor, language, openaccess, pubyear, restype, srctype, subjarea  |  This parameter is used when a user wants to execute deep pagination searching (i.e. iterate to the end of a search result set). |



### Posibles respuestas a la query: 

|  Status code  | description  |  
|---|---|
|  200 | This is XML representing the requested document  | 
|  400 | Invalid Request: This is an error that occurs when invalid information is submitted.  |
|  401 | Authentication Error: This is an error that occurs when a user cannot be authenticated due to missing/invalid credentials (authtoken or APIKey).  |
| 403  | Authorization/Entitlements Error: This is an error that occurs when a user cannot be authenticated or entitlements cannot be validated. |
|  405 |  nvalid HTTP Method: This is an error that occurs when the requested HTTP Method is invalid.|
|  406 | Invalid Mime Type: This is an error that occurs when the requested mime type is invalid. |
|  429 | Quota Exceeded: This is an error that occurs when a requester has exceeded the quota limits associated with their API Key. |
|  500 | Generic Error: This is a general purpose error condition, typically due to back-end processing errors. |



## Queries de ejemplo

