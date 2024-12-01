Historia de Usuario 1: Autenticación de Usuario
Como usuario,
quiero poder iniciar sesión con mi ID y correo electrónico,
para acceder a mis datos y realizar operaciones seguras.

Criterios de Aceptación:

El usuario debe poder enviar sus credenciales (ID y correo) al servidor.
El servidor debe verificar las credenciales y responder con un mensaje de éxito o error.
Si las credenciales son correctas, el usuario debe poder realizar operaciones adicionales.

Historia de Usuario 2: Actualización de Datos del Cliente
Como usuario registrado,
quiero poder actualizar mis datos personales (nombre y correo),
para mantener mi información actualizada.

Criterios de Aceptación:

El usuario debe poder enviar una solicitud de actualización con los nuevos datos.
El servidor debe actualizar los datos del cliente en el mapa de clientes.
El servidor debe responder con un mensaje de confirmación de la actualización.

Historia de Usuario 3: Eliminación de Cuenta de Cliente
Como usuario registrado,
quiero poder eliminar mi cuenta,
para dejar de usar el servicio y asegurarme de que mis datos sean eliminados.

Criterios de Aceptación:

El usuario debe poder enviar una solicitud de eliminación de cuenta.
El servidor debe eliminar los datos del cliente del mapa de clientes.
El servidor debe responder con un mensaje de confirmación de la eliminación.

Historia de Usuario 4: Consulta de Datos del Cliente
Como usuario registrado,
quiero poder consultar mis datos personales,
para verificar la información almacenada en el servidor.

Criterios de Aceptación:

El usuario debe poder enviar una solicitud de consulta de datos.
El servidor debe responder con los datos del cliente almacenados.
Los datos deben incluir el ID, nombre y correo del cliente.

Historia de Usuario 5: Notificación de Cambios en el Servidor
Como administrador del servidor,
quiero poder notificar a todos los clientes conectados sobre cambios importantes,
para mantener a los usuarios informados sobre el estado del servicio.

Criterios de Aceptación:

El administrador debe poder enviar un mensaje de notificación a todos los clientes conectados.
El servidor debe retransmitir el mensaje a todos los clientes activos.
Los clientes deben recibir y mostrar el mensaje de notificación en su consola.
