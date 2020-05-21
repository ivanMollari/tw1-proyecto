$(document).ready(() => {
    addEvents();

    function addEvents() {
        $(".cambiar-cantidad").off('click').on('click', (event) => {
            event.preventDefault();
            var clickedButton = $(event.target);
            var comidaId = getComidaId(clickedButton);
            var cantidadTarget = $("#cantidad-"+comidaId)[0];
            var cantidad = parseInt(cantidadTarget.innerText);
            var newCantidad = 0;
            var precio = $($(`#precio-${comidaId}`)[0]).val();

            if( clickedButton.attr('type-change') === 'increment') {
                newCantidad = cantidad + 1;
            } else {
                newCantidad = cantidad - 1;
            }

            var decrementButton = $(`[comida-id=${comidaId}] [type-change="decrement"]`)[0];
            var agregarButton = $(`#agregar-${comidaId}`)[0];
            decrementButton.disabled = newCantidad === 0;
            agregarButton.disabled = newCantidad === 0;
            cantidadTarget.innerText = newCantidad;

            $(`#subtotal-${comidaId}`)[0].innerText = precio * newCantidad + "$";
        });

        $(".button-agregar").off('click').on('click', (event) => {
            event.preventDefault();
            var clickedButton = $(event.target);
            var comidaId = getComidaId(clickedButton);
            var cantidadProductos = $(".productos").children('div').length;

            if( cantidadProductos === 0 ) {
                $(".productos")[0].innerHTML = "";
            }

            addComidaToTotal(comidaId);

            calculateTotal();
        });

        $(".borrar").off('click').on('click', event => {
            event.preventDefault();
            var clickedButton = $(event.target);
            $(clickedButton).parent('.producto').remove();
            var cantidadProductos = $(".productos").children('div').length;


            if( cantidadProductos === 0 ) {
                $(".productos")[0].innerHTML = "<p>No hay productos seleccionados</p>";
            }

            calculateTotal();
        });
    }


    function calculateTotal() {
        var productos = $(".producto");
        var total = 0;

        $(productos).each( index => {
            var subtotalTag = $($(productos)[index]).children('[subtotal]');

            total += parseInt($(subtotalTag).attr('subtotal'));
            console.log(total);
        });

        $("#total")[0].innerText = total + " $";
    };

    function addComidaToTotal(comidaId) {
        var nombre = $(`#nombre-${comidaId}`).val();
        var cantidad = getCantidad(comidaId);
        var producto = $(`#producto-${comidaId}`)[0];

        var newProducto = `
            <div class="producto" id="producto-${comidaId}">
                <p class="col-lg-6">${nombre} x ${cantidad}</p>
                <p class="col-lg-4" subtotal=${getSubtotal(comidaId)}> ${getSubtotal(comidaId)} $ </p>
                <p class="col-lg-2 borrar" value=${comidaId}>Borrar</p>
            </div>`

        var updateProducto = `
            <p class="col-lg-6">${nombre} x ${cantidad}</p>
            <p class="col-lg-4" subtotal=${getSubtotal(comidaId)}> ${getSubtotal(comidaId)} $</p>
            <p class="col-lg-2 borrar" value=${comidaId}>Borrar</p>`

        if(!!producto) {
            producto.innerHTML = updateProducto;
        } else {
            $($(".productos")[0]).append(newProducto);
        }
        addEvents();
    }

    function getComidaId(element) {
        return $($(element).parents('[comida-id]')[0]).attr('comida-id');
    }

    function getCantidad(comidaId) {
        return $(`#cantidad-${comidaId}`)[0].innerText;
    };

    function getSubtotal(comidaId) {
        var precio = $(`#precio-${comidaId}`).val();
        var cantidad = getCantidad(comidaId);

        return precio * cantidad;
    }

});
