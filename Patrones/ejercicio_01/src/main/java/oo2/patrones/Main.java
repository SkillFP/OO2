package oo2.patrones;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.agregarSocio(new Socio("Mateo", "mateo@example.com", "12345"));
        biblioteca.agregarSocio(new Socio("Ori", "ori@example.com", "67890"));

        VoorheesExporter voorhees = new VoorheesExporter();
        biblioteca.setExporter(voorhees);
        System.out.println(biblioteca.exportarSocios());

        VoorheesExporter jacksonExporter = new JacksonAdapter();
        biblioteca.setExporter(jacksonExporter);
        System.out.println(biblioteca.exportarSocios());

        VoorheesExporter jsonSimpleExporter = new JsonSimpleAdapter();
        biblioteca.setExporter(jsonSimpleExporter);
        System.out.println(biblioteca.exportarSocios());
    }
}