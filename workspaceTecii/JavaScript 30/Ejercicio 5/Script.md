# Script Ejercicio 15 by Dino

# Add Item
Agrega el ítem escrito en la forma en un arreglo de objetos llamado Ítems y limpia la forma para volver a agregar otro ítem sin problema alguno.

Item push ítem agrega el ítem de la forma como un objeto de tipo items.

Mandan a llamar la función populate list mandando como parámetros los items y una lista de ítems que mostrara todos los ítems almacenados.

Local storage set item permite guardar el arreglo de objetos en un documento con formato JSON.

## Populate List 
lo que hace es que obtiene lo que esta almacenado en la lista (Arreglo de objetos con datos) para devolver un arreglo de los datos
y mostrarlos en forma de lista con formato html (cada item genera un ítem list y en ese ítem list se muestra el ítem generado por el arreglo de datos obtenido del arreglo de objetos).
Ademas cuenta con un checkbox que cuando se selecciona un item, lo marca como checked y muestra un ítem de resultado.

Nota: Cada vez que se agrega un nuevo ítem, la lista se vuelve a cargar, mostrando nuevamente todos los items incluyendo el recientemente agregado.


# Almacenamiento Persistente
Guardamos la lista de objetos de manera local, con la finalidad de que cada vez que se entre a la pagina, se cargue la lista de los ítems. (persistente)

# Stringify
Convierte los arreglos y los objetos en strings en formato JSON.


# Toogle Done
Interruptor que se ejecuta cuando se selecciona el checkbox de la lista de ítems, lo que hace es intercambiar el estado del parámetro Done