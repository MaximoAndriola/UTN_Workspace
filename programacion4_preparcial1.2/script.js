const BD_URL = "http://localhost:3000";
const diosesList = document.getElementById("dioses-list");
const addDiosForm = document.getElementById("add-dios-form");
const buscarForm = document.getElementById("buscar-form");
const buscarInput = document.getElementById("buscar");
const diosEncontrado = document.getElementById("dios-encontrado");
const nombreInput = document.getElementById("nombre");
const dominioInput = document.getElementById("dominio");
const simboloInput = document.getElementById("simbolo");
const poderInput = document.getElementById("poder");
const ciudadInput = document.getElementById("ciudad");


async function cargarDioses() {

    try {
        let response = await fetch(`${BD_URL}/dioses`);
        let dioses = await response.json();

        diosesList.innerHTML = "";

        dioses.forEach(dios => {
            const li = document.createElement("li");
            li.className = "dios-item"; // Agregar clase común

            const nombre = document.createElement("li");
            nombre.className = "dios-data"; // Agregar clase para datos
            nombre.textContent = "nombre: " + dios.nombre;

            const dominio = document.createElement("li");
            dominio.className = "dios-data";
            dominio.textContent = "dominio: " + dios.dominio;

            const simbolo = document.createElement("li");
            simbolo.className = "dios-data";
            simbolo.textContent = "simbolo: " + dios.simbolo;

            const poder = document.createElement("li");
            poder.className = "dios-data";
            poder.textContent = "poder: " + dios.poder;

            const ciudad = document.createElement("li");
            ciudad.className = "dios-data";
            ciudad.textContent = "ciudad: " + dios.ciudad;
            
            const botonEliminar = document.createElement("button");
            botonEliminar.textContent = "Eliminar";

            botonEliminar.addEventListener("click", () => eliminarDios(dios.id));

            li.appendChild(nombre)
            li.appendChild(dominio)
            li.appendChild(simbolo)
            li.appendChild(poder)
            li.appendChild(ciudad)
            
            li.appendChild(botonEliminar);
            diosesList.appendChild(li);
        });
    } catch (error) {
        console.log("error al cargar dioses: " + error);
    }
}

async function agregarDios(event) {
    event.preventDefault();

    const nuevoDios = {
        nombre: nombreInput.value,
        dominio: dominioInput.value,
        simbolo: simboloInput.value,
        poder: parseInt(poderInput.value),
        ciudad: ciudadInput.value
    };

    try {
        await fetch(`${BD_URL}/dioses`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(nuevoDios)
        });

        nombreInput.value = "";
        dominioInput.value = "";
        simboloInput.value = "";
        poderInput.value = "";
        ciudadInput.value = "";

        await cargarDioses();
    } catch (error) {
        console.error("Error al agregar dios:", error);
    }
}

async function eliminarDios(id) {
    try {
        await fetch(`${BD_URL}/dioses/${id}`, { method: "DELETE" });
        await cargarDioses();
    } catch (error) {
        console.error("Error al eliminar dios:", error);
    }
}

async function buscarDiosPorId(event) {
    event.preventDefault();

    try {
        // Obtener el ID del input (similar a como se obtienen los valores en agregarDios)
        let id = buscarInput.value;
        
        // Hacer la petición al servidor (similar a cargarDioses)
        let response = await fetch(`${BD_URL}/dioses/${id}`);
        let dios = await response.json();

        // Limpiar el contenedor (similar a cargarDioses)
        diosEncontrado.innerHTML = "";

        // Crear elementos para mostrar el dios (similar a cargarDioses)
        const li = document.createElement("li");
        li.className = "dios-item"; // Usar la misma clase común

        const nombre = document.createElement("li");
        nombre.className = "dios-data"; // Usar la misma clase para datos
        nombre.textContent = "nombre: " + dios.nombre;

        const dominio = document.createElement("li");
        dominio.className = "dios-data";
        dominio.textContent = "dominio: " + dios.dominio;

        const simbolo = document.createElement("li");
        simbolo.className = "dios-data";
        simbolo.textContent = "simbolo: " + dios.simbolo;

        const poder = document.createElement("li");
        poder.className = "dios-data";
        poder.textContent = "poder: " + dios.poder;

        const ciudad = document.createElement("li");
        ciudad.className = "dios-data";
        ciudad.textContent = "ciudad: " + dios.ciudad;
        
        const botonEliminar = document.createElement("button");
        botonEliminar.textContent = "Eliminar";

        botonEliminar.addEventListener("click", () => eliminarDios(dios.id));

        // Agregar todos los elementos al contenedor (igual que en cargarDioses)
        li.appendChild(nombre);
        li.appendChild(dominio);
        li.appendChild(simbolo);
        li.appendChild(poder);
        li.appendChild(ciudad);
        li.appendChild(botonEliminar);
        
        diosEncontrado.appendChild(li);

        // Limpiar el input después de buscar
        buscarInput.value = "";
        
    } catch (error) {
        console.log("Error al buscar dios: " + error);
        diosEncontrado.innerHTML = "";
        
        const errorMsg = document.createElement("li");
        errorMsg.className = "error-message";
        errorMsg.textContent = "Dios no encontrado";
        diosEncontrado.appendChild(errorMsg);
    }
}

document.addEventListener('DOMContentLoaded', function() {
    cargarDioses();
    addDiosForm.addEventListener("submit", agregarDios);
    buscarForm.addEventListener("submit", buscarDiosPorId);
});