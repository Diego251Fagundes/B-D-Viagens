function mostrarModal(event) {
    event.preventDefault();
    const modal = document.getElementById('reservaModal');
    modal.style.display = 'block';
}

function redirecionarInicio() {
    document.getElementById('reservaForm').submit();
}
