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

    $.extend($.validator.messages, {
        required: "Este campo é obrigatório!",
        date: "Data Inválida!",
        email: "E-mail Inválido!",
        url: "URL inválida!",
        number: "Número inválido",
        digits: "Por favor, insira apenas dígitos",
        maxlength: $.validator.format("Número máximo de letras: {0}."),
        minlength: $.validator.format("Número mínimo de caracteres: {0}."),
        rangelength: $.validator.format("Por favor, seu texto deve ter pelo menos {0} e no máximo {1} caracteres."),
        range: $.validator.format("Por favor, insira um valor entre {0} e {1}.")

    });

    $.extend($.validator.methods, {
        date: function(value, element) {
            var check = false;
            var re = /^\d{1,2}\/\d{1,2}\/\d{4}$/;
            if (re.test(value)) {
                var adata = value.split('/');
                var gg = parseInt(adata[0], 10);
                var mm = parseInt(adata[1], 10);
                var aaaa = parseInt(adata[2], 10);
                var xdata = new Date(aaaa, mm - 1, gg);
                if ((xdata.getFullYear() === aaaa) && (xdata.getMonth() === mm - 1) && (xdata.getDate() === gg)) {
                    check = true;
                } else {
                    check = false;
                }
            } else {
                check = false;
            }
            return this.optional(element) || check;
        }
    });

    $("form").validate();

});


