package ar.edu.unahur.obj2.Cazadores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.Zona;
import ar.edu.unahur.obj2.Profugo.*;

import java.util.List;

public class AgenciaTest {

    private Profugo profugo1, profugo2, profugo3;
    private Zona zona;
    private CazadorUrbano urbano;
    private CazadorRural rural;
    private CazadorSigiloso sigiloso;

    @BeforeEach
    void setUp() {
        // Prófugos preparados para que cada tipo de cazador pueda capturarlos
        profugo1 = new Profugo(30, 40, false); // no nervioso, habilidad 40
        profugo2 = new Profugo(20, 60, true);  // nervioso, habilidad 60
        profugo3 = new Profugo(25, 45, false); // no nervioso, habilidad 45

        zona = new Zona("Centro");
        zona.agregarProfugo(profugo1);
        zona.agregarProfugo(profugo2);
        zona.agregarProfugo(profugo3);

        urbano = new CazadorUrbano(50);
        rural = new CazadorRural(50);
        sigiloso = new CazadorSigiloso(50);
    }

    // ----------------------------
    // Tests de captura por tipo de cazador
    // ----------------------------
    @Test
    void testCapturaUrbano() {
        urbano.cazarEn(zona);

    List<Iprofugo> capturados = urbano.getProfugosCapturados();
    assertFalse(capturados.isEmpty(), "Debe haber capturados por el cazador urbano");

    capturados.forEach(p -> {
    assertFalse(p.esNervioso(), "El prófugo urbano capturado no debe estar nervioso");
    assertTrue(urbano.getExperiencia() > p.getInocencia());
    });
    }

    @Test
    void testCapturaRural() {
        rural.cazarEn(zona);

        List<Iprofugo> capturados = rural.getProfugosCapturados();
        assertFalse(capturados.isEmpty(), "Debe haber capturados por el cazador rural");

        for (Iprofugo p : capturados) {
            assertTrue(p.esNervioso(), "El prófugo rural capturado debe estar nervioso");
            assertTrue(rural.getExperiencia() > p.getInocencia());
        }
    }

    @Test
    void testCapturaSigiloso() {
        sigiloso.cazarEn(zona);

        List<Iprofugo> capturados = sigiloso.getProfugosCapturados();
        assertFalse(capturados.isEmpty(), "Debe haber capturados por el cazador sigiloso");

        for (Iprofugo p : capturados) {
            assertTrue(p.getHabilidad() < 50, "Prófugo capturado por sigiloso debe tener habilidad < 50");
            assertTrue(sigiloso.getExperiencia() > p.getInocencia());
        }
    }

    // ----------------------------
    // Tests de decoradores
    // ----------------------------
    @Test
    void testArteMarcialDecorator() {
        Iprofugo profugoDecorado = new ArteMarcialProfugoDecorator(profugo1);

        int habilidadOriginal = profugo1.getHabilidad();
        int habilidadDecorada = profugoDecorado.getHabilidad();

        assertEquals(Math.min(100, habilidadOriginal * 2), habilidadDecorada);
        assertEquals(profugo1.getInocencia(), profugoDecorado.getInocencia());
        assertEquals(profugo1.esNervioso(), profugoDecorado.esNervioso());
    }

    @Test
    void testEntrenamientoEliteDecorator() {
        Iprofugo profugoDecorado = new EntrenamientoEliteProfugoDecorator(profugo1);

        assertFalse(profugoDecorado.esNervioso());
        assertEquals(profugo1.getHabilidad(), profugoDecorado.getHabilidad());
        assertEquals(profugo1.getInocencia(), profugoDecorado.getInocencia());
    }

    @Test
    void testProteccionLegalDecorator() {
        Iprofugo profugoDecorado = new ProteccionLegalProfugoDecorator(new Profugo(30, 50, true));

        assertEquals(40, profugoDecorado.getInocencia(), "Inocencia nunca puede ser < 40");
        assertEquals(50, profugoDecorado.getHabilidad());
        assertTrue(profugoDecorado.esNervioso());
    }

    @Test
    void testDecoradoresApilados() {
        Iprofugo profugo = new Profugo(20, 30, true);

        Iprofugo decorado = new ProteccionLegalProfugoDecorator(
                               new EntrenamientoEliteProfugoDecorator(
                                 new ArteMarcialProfugoDecorator(profugo)));

        assertEquals(40, decorado.getInocencia(), "Protección legal ajusta inocencia a 40");
        assertEquals(60, decorado.getHabilidad(), "Arte marcial duplica habilidad");
        assertFalse(decorado.esNervioso(), "Entrenamiento elite elimina nerviosismo");
    }

    // ----------------------------
    // Test de experiencia de cazador
    // ----------------------------
    @Test
    void testExperienciaSeSumaCorrectamente() {
        CazadorUrbano cazador = new CazadorUrbano(50);
        Profugo p1 = new Profugo(10, 20, false); // captura exitosa
        Profugo p2 = new Profugo(40, 80, true);  // será intimidado

        Zona z = new Zona("Test");
        z.agregarProfugo(p1);
        z.agregarProfugo(p2);

        cazador.cazarEn(z);

        int minimaHabilidad = p2.getHabilidad(); // un solo intimidado
        int esperada = 50 + minimaHabilidad + 2 * 1; // capturó p1
        assertEquals(esperada, cazador.getExperiencia());
    }

    // ----------------------------
    // Test que zona elimina profugos capturados
    // ----------------------------
    @Test
    void testZonaSeVacíaDeCapturados() {
        CazadorUrbano cazador = new CazadorUrbano(50);
        Profugo p1 = new Profugo(10, 20, false); // captura
        Zona z = new Zona("Test");
        z.agregarProfugo(p1);

        cazador.cazarEn(z);
        assertTrue(z.getProfugos().isEmpty(), "La zona debe quedar sin los prófugos capturados");
    }
}
