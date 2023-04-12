# NAOReto2
documentation of Scopus Search API


# Scopus API

La API de Scopus es una interfaz de programación de aplicaciones que permite acceder a la base de datos de Scopus y realizar búsquedas avanzadas en la misma.

## Endpoint

El endpoint principal de la API es **'https://api.elsevier.com/content/search/scopus'**.

## Autenticacion

La autenticación se realiza mediante un API Key proporcionado por Elsevier. Este API Key debe ser enviado en el encabezado **X-ELS-APIKey** de todas las solicitudes a la API.

## Parametros de busqueda

Algunos de los parametros mas importantes son: 

`query`: especifica la cadena de búsqueda. Ejemplo: **query=TITLE-ABS-KEY**(genome OR sequencing)

`field`:  especifica el campo de búsqueda. Ejemplo: **field=title,abstract**.

`date`:  especifica la fecha de publicación. Ejemplo: **date=2016-2022**.

`sort`:  especifica el orden de los resultados. Ejemplo: **sort=citedby-count**.

`count`:  especifica el numero maximo de resultados que queremos devolver. Ejemplo: **count=10**.

`subj`:  especifica el tipo de codigo de area asociado a la categoria . Ejemplo: **subj=AGRI**.


 
 para todos los parametros de la consulta se puede ver la documentacion oficial, aqui se detallan los mas importantes
 https://dev.elsevier.com/documentation/ScopusSearchAPI.wadl
 
 
## Respuestas 

La API de Scopus devuelve los resultados en formato JSON. Cada registro de publicación se representa como un objeto JSON con una serie de campos que incluyen información sobre el título, autores, afiliaciones, resumen, palabras clave, fecha de publicación, número de citas y otros metadatos relevantes.

## Solicitud de ejemplo

A continuación se muestra un ejemplo de solicitud para buscar todos los registros de publicación relacionados con "machine learning" publicados en 2022:

`curl --location --request GET 'https://api.elsevier.com/content/search/scopus?query=TITLE-ABS-KEY(machine learning)&date=2022&field=title,abstract,authors,citedby-count' \
--header 'X-ELS-APIKey: {tu_api_key}'`

## Mas informacion

Para obtener más información sobre la API de Scopus, consulte la documentación oficial proporcionada por Elsevier: https://dev.elsevier.com/documentation/ScopusSearchAPI.wadl




-Thomas


