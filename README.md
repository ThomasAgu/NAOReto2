# Google Scholar Author API

Google Scholar Author API es una API de Google que te permite acceder a información sobre autores de Google Scholar. Esta API te permite buscar autores por nombre, obtener sus perfiles y estadísticas de citas, y también buscar publicaciones asociadas con un autor específico.

# Primeros pasos

Para comenzar a usar la API, necesitarás seguir los siguientes pasos:/

1. Crear un proyecto en Google Cloud Console: Antes de poder usar la API, deberás crear un proyecto en Google Cloud Console. Para hacer esto, debes tener una cuenta de Google y acceder a la consola de Google Cloud. Una vez allí, selecciona "Crear proyecto" y sigue las instrucciones para crear tu proyecto.
2. Habilitar Google Scholar Author API: Después de crear tu proyecto, debes habilitar la API. Para hacer esto, busca la API en la lista de APIs disponibles y haz clic en "Habilitar".
3. Crear credenciales de API: Para autenticarte con la API, necesitarás crear credenciales de API. En la consola de Google Cloud, selecciona "Credenciales" en el menú de la izquierda y sigue las instrucciones para crear un par de claves de API.

## Endpoints

| Titulo | Descripción | URL | Parámetros | Respuesta |
| --- | --- | --- | --- | --- |
| Buscar autores | Este endpoint se utiliza para buscar autores por nombre. | GET https://scholar.google.com/citations?view_op=search_authors&mauthors=%7Bnombre_del_autor%7D | nombre_del_autor
 (requerido): el nombre del autor que se desea buscar. | La respuesta se presenta en formato HTML y contiene información sobre los autores encontrados, incluyendo su nombre, institución, número de citas y perfiles de Google Scholar |
| Obtener el perfil de un autor | Este endpoint se utiliza para obtener el perfil de un autor específico. | GET https://scholar.google.com/citations?user=%7Bid_del_autor%7D | id_del_autor
 (requerido): el identificador único del autor cuyo perfil se desea obtener. | La respuesta se presenta en formato HTML y contiene información sobre el perfil del autor, incluyendo su nombre, institución, número de citas y publicaciones en Google Scholar. |
| Buscar publicaciones | Este endpoint se utiliza para buscar publicaciones asociadas con un autor específico. | GET https://scholar.google.com/citations?view_op=view_citation&hl=en&oe=ASCII&citation_for_view=%7Bid_de_la_publicacion%7D | id_de_la_publicacion
 (requerido): el identificador único de la publicación que se desea buscar. | La respuesta se presenta en formato HTML y contiene información sobre la publicación, incluyendo su título, autores, revista o conferencia, año de publicación y citas. |

## Autenticación

La autenticación se realiza mediante un API Key proporcionado por la API. Este API Key debe ser enviado en el encabezado `api_key` de todas las solicitudes a la API.

## Parámetros de búsqueda

Algunos de los parámetros más importantes son:

### Generales:

- `view_op`:  para ver partes específicas de la página (**view_citation** or **list_colleagues**)
- `sort`: especifica el orden de los resultados. (************title************ o **************pubdate**************)
- `citation_id`: es usado para devolver  una citación individual en un articulo. Parametro obligatorio cuando view_op = view_citation

### Paginación:

- `start`: para definir a partir de que articulo queremos empezar a devvolver. Default= 0
- `count`: especifica el número máximo de resultados que queremos devolver. Ejemplo: **count=10**.

### Parámetros Serpapi:

[OBLIGATORIO]

- `engine`: Para elegir el motor de Google Scholar Author API.
- `api_key`: Para especificar la API Key que estamos usando.

[OPCIONAL]

- `no_cache`: Para consultar siempre de la API incluso aunque tengamos información cacheada
- `async`: Para hacer la consulta asincrónica
- `output`: Para definir el formato de respuesta. Por defecto en Json

## Mas información

Para obtener más información sobre la API de Google Author y ejemplos de llamada a la API, consulte la documentación oficial proporcionada por la página: [Google Scholar Author API - SerpApi](https://serpapi.com/google-scholar-author-api)



-Thomas


