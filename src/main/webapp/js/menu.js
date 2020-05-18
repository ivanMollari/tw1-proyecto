document.addEventListener('DOMContentLoaded', () => {
    var cantidad = document.getElementById('cantidad');
    var subtotal = document.getElementById('subtotal');
    var precio = document.getElementById('precio');
    precio = parseInt(precio.innerText);

    var incrementButton = document.getElementById('boton-incrementar');
    incrementButton.addEventListener('click', () => {
        var newCantidad = parseInt(cantidad.innerText) + 1;

        cantidad.innerText = newCantidad;

        subtotal.innerText = calcularSubtotal(newCantidad)+" $";

        if(newCantidad > 0) {
            decrementButton.disabled = false;
        }
    });

    var decrementButton = document.getElementById('boton-decrementar');
    decrementButton.addEventListener('click', () => {
        var newCantidad = parseInt(cantidad.innerText) - 1;

        cantidad.innerText = newCantidad;

        subtotal.innerText = calcularSubtotal(newCantidad)+" $";
        if(newCantidad === 0) {
            decrementButton.disabled = true;
        }
    });

    function calcularSubtotal(cantidad) {
        return (precio * cantidad).toFixed(2);
    }
});
