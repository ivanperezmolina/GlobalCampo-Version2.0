# GlobalCampo-Version2.0
Mantenemos nuestro lema: "Ayudar al agricultor a gestionar su campo "

### Presentación a la versión 2.0

Bien, despues de dos meses de formación, de nuevas ideas y también de alguna reflexiones; ya esta con nosotros la versión 2.0 de Globalcampo.

A lo largo de este repositorio voy a explicar las principales diferencias entre la versión 1.0 y la versión 2.0. Así que recomiendo antes de ver esta nueva versión, la lectura de la [versión 1.0 de Globalcampo](https://github.com/ivanperezmolina/GlobalCampo-Version1.0).

#

#### 🌲COMENCEMOS🌲


## Separemos nuestro proyecto en Modelo - Vista- Controlador

La razón principal por la que nos interesa separar cuanto antes nuestro proyecto en MVC es la seguirdad y comodidad que tenemos sabiendo que cuando hacemos un cambio en alguna parte de nuestro código, esto no afecte otra parte del mismo.
Ademas, tendremos nuestro proyecto separado, así si tenemos un error en la vista que mostramos al usuario; no es necesario revisar un documento que incluya todo el código mezclado.

<p align="center"> 

<img src="Fotos/Diagrama mvc.jpg">

</p>

Expliquemos un poco que hace cada parte del patrón MVC:

#### MODELO

Se encarga de los datos, generalmente consultando la base de datos. Actualizaciones, consultas, búsquedas, etc. 
En el modelo de GlobalCampo 2.0 se incluyem las conexiones con la BBDD, la clase del login y todas las clases que incluye nuestro proyecto (Poda.java // Recolecta.java...)

<p align="center"> 

<img src="Fotos/modelo.png">

</p>

#### VISTA

Son la representación visual de los datos, todo lo que tenga que ver con la interfaz gráfica va aquí. Ni el modelo ni el controlador se preocupan de cómo se verán los datos, esa responsabilidad es únicamente de la vista. 
En la vista de GlobalCampo 2.0 se incluyen los ficheros .jsp que será lo que el usuario vea (index.jsp // editarPoda.jsp...)

<p align="center"> 

<img src="Fotos/vista.png">

</p>

#### CONTROLADOR

Se encarga de... controlar, recibe las órdenes del usuario y se encarga de solicitar los datos al modelo y de comunicárselos a la vista.
Es lo que se conoce como un Servlet, el cual va a gestionar todo
Los servlet que incluye GlobalCampo 2.0 son los que para cada acción del agricultor se debe administrar (un servlet para las podas, otro para las recolectas...)

<p align="center"> 

<img src="Fotos/controlador.png">

</p>

#### DAO (Objeto de acceso a datos)

El DAO va a incluir todas las "sentencias SQL" que vamos a hacer a la BBDD. 

<p align="center"> 

<img src="Fotos/dao.png">

</p>











Una vez estamos dentro del panel de control ( _newhtml2.html_ ); podemos observar como tenemos dos perfiles: **Agricultor** y **Gestión**

<p align="center"> 

<img src="Fotos/2.png">

</p>


### <p style="color:purple">Agricultor</p>

Un agricultor es la persona que día a día esta en el cultivo. Quien coje la aceituna, poda los olivos y aplica los tratamientos necesarios. Desde este perfil podemos:
* Gestionar nuestra recolecta de aceitunas
* Gestionar las podas realizadas al cultivo
* Gestionar los tratamientos aplicados en el cultivo



## Gestión de las recolectas de aceitunas

Desde esta página (el agricultor) podrá añadir todas las recolectas que realice en sus cultivos. 

Para añadir una recolecta, se debe proporcionar la fecha en la que se ha realizado la recolecta, los kilos obtenidos, los trabajadores que ese día acudieron al cultivo, la persona encargada de esa recolecta (su DNI), una breve descripción (Aceitunas del arbol o del suelo...), y un desplegable para que pueda escoger la finca que desee (previamente agregada por un gerente de la cooperativa). Podra añadir recolectas, modificarlas o borrarlas. También encontramos un botón para poder volver al panel de control.

_indexRecolecta.jsp -->actualizarecolecta.jsp//nuevarecolecta.jsp//borrarecolecta.jsp_
<p align="center"> 

<img src="Fotos/3.png">

</p>

<hr><hr>

## Gestión de las podas realizadas al olivo

Desde esta página (el agricultor) podrá gestionar todas las podas que se realice al olivar.

 Para añadir una poda, debe proporcionarse la fecha en la que se ha realizado la poda, los olivos que se han podado, una breve descripción (Tipo de poda...), y un desplegable para que pueda escoger la finca que desea (previamente agregada por un gerente de la cooperativa). Podra añadir podas, modificarlas o borrarlas. También encontramos un botón para poder volver al panel de control

_indexPoda.jsp -->actualizapoda.jsp//nuevapoda.jsp//borrapoda.jsp_
<p align="center"> 

<img src="Fotos/4.png">

</p>

<hr><hr>

## Gestión del tratamiento aplicado a los olivos

Desde esta página (el agricultor) podrá gestionar todos los tratamientos que se realice al olivo. 

Para añadir un tratamiento, debe proporcionarse la fecha en la que se ha realizado el tratamiento, una breve descripción (Porque se hace...), que tipo de tratamiento (Abono, Sulfato), un desplegable para que pueda escoger la finca que desea (previamente agregada por un gerente de la cooperativa) y otro desplegable en el cual se podra escoger el fertilizante (que previamente el gerente ha tenido que añadir y gestionar). Podra añadir tratamientos, modificarlos o borrarlos. También encontramos un botón para poder volver al panel de control

_indexTratamiento.jsp -->actualizatratamiento.jsp//nuevotratamiento.jsp//borratratamiento.jsp_
<p align="center"> 

<img src="Fotos/5.png">

</p>

<hr><hr><hr>

### Gestión (Gerente de cooperativa)

Un gerente de cooperativa es la persona que esta en la cooperativa a diario. La cual se encarga de registrar y modificar cultivos (como sus socios lo soliciten) y atender a los gerentes de fertilizantes (los cuales traen nuevos productos y son sacados a la venta para que un agricultor pueda comprarlos). Desde este perfil podemos:
* Gestionar los cultivos
* Gestionar los fertilizantes





## Gestión de los cultivos

Desde esta página (el gerente) podrá gestionar todos los cultivos que sus socios tengan. (Un ejemplo, un agricultor se compra un cultivo, y si quieren hacer recolectas en el mismo...; debe ir a su gerente de la cooperativa y solicitar la alta del cultivo. O tal vez venda un cultivo; en ese caso debe de solicitar dar de baja el cultivo).

Para añadir un cultivo debe proporcionarse el nombre del cultivo, una breve descripción (dueño de la finca, ubicación...), en que número de registro quedara registrada en los registros de la cooperativa y la cooperativa habitual donde se llevará las gestiones (Las cooperativas suelen funcionar en red; puedo de dar una finca en un sitio pero llevar las aceitunas a otra). Podra añadir cultivos, modificarlos o borrarlos. También encontramos un botón para poder volver al panel de control.

_indexCultivo.jsp -->actualizaCultivo.jsp//nuevoCultivo.jsp//borraCultivo.jsp_
<p align="center"> 

<img src="Fotos/6.png">

</p>

<hr><hr>

## Gestión en fertilizantes

Desde esta página (el gerente de la cooperativa) podrá gestionar todos los fertilizantes que un gerente externo de fertilizantes le ofrezca. (Un ejemplo, un gerente acude a la cooperativa con un nuevo producto y a la cooperativa le interesa; el gerente de la cooperativa lo registrará y a partir de hay los agricultores podrán comprarlo y aplicarlo a sus cultivos).

Para añadir un fertilizante debe proporcionarse el nombre del fertilizante, una breve descripción (para que cultivo es recomendado, precio...), clasificación (en la que se indica si es un sulfato, abono, algas...), y las unidades en las que se venden (Kg/ Litros...). Podra añadir fertilizantes, modificarlos o borrarlos. También encontramos un botón para poder volver al panel de control

_indexFertilizante.jsp -->actualizafertilizante.jsp//nuevofertilizante.jsp//borrafertilizante.jsp_
<p align="center"> 

<img src="Fotos/7.png">

</p>

### Despedida
Y eso es todo. Espero poder hacer la vida agrícola más facil. 

_Recordatorio: Esto es la versión 1.0; en versiones posteriores se espera mejorar conceptos como hacer un login para cada perfil, mapa para poder ver las fincas, información en los botones... y muchos mas cambios. TODO Y MAS PROXIMAMENTE..._

#### ☘VIDEO EXPLICATIVO☘

https://youtu.be/BXZDCDlUeuc



