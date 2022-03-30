$(document).ready(function () {
    $('#info-table').DataTable({
        select: true,
        "aLengthMenu": [[25, 50, 75, -1], [25, 50, 75, "Все"]],
        "iDisplayLength": 25,
        dom: 'lBfrtip',
        buttons: [{
            extend: 'excelHtml5',
            autoFilter: true,
            sheetName: 'Exported data'
        }],
    });
});

function getValueDate() {
    date = document.getElementById('DateValues');
    if (date.value) {
        window.location.href = '/mercuryTcp/' + date.value;
    } else alert('Выберите дату');
}