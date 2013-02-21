$(document).ready(function() {
    $("#inserir").click(function() {
        $("#pessoas_selecionadas").prepend($("#lista_pessoas option:selected"));
    });
    $("#remover").click(function() {
        $("#lista_pessoas").prepend($("#pessoas_selecionadas option:selected"));
    });

    $("#salvar").click(function() {
        $("#pessoas_selecionadas option").each(function() {
            $(this).attr('selected', 'selected');
        });
    });

    $(".data").datepicker({format: "dd/mm/yyyy"});
});

