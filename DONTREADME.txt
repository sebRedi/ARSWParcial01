API key: UNF1JDVBWBIJUBH8

La app recibe el identificador de una acción (i.e "MSFT")

La app debe mostrar el histórico de la valoración intra-día, diaria, semanal y mensual (usando el API)

El diseño debe estar pensado para poder conectar otros proveedores de servicio

El servidor escrito en Spring servirá como un gateway para encapsular llamadas a otros servicios Web externos

La aplicación debe ser multiusuario.

Todos los protocolos de comunicación serán sobre HTTP.

Los formatos de los mensajes de intercambio serán siempre JSON.





Construir un cliente Java que permita probar las funciones del servidor fachada. El cliente utiliza simples conexiones http para conectarse a los servicios. Este cliente debe hacer pruebas de concurrencia en su servidor de backend. El cliente es una aplicación de consola, es decir sin interfaz gráfica.

La fachada de servicios tendrá un caché que permitirá que llamados que ya se han realizado a las implementaciones concretas con parámetros específicos no se realicen nuevamente. Se puede almacenar el llamado como un String con su respectiva respuesta, y comparar el string respectivo. El caché es una simple estructura de datos.

Se debe poder extender fácilmente, por ejemplo, es fácil agregar nuevas funcionalidades, o es fácil cambiar el proveedor de una funcionalidad.


