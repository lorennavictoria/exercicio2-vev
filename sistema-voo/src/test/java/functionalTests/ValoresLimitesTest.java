package functionalTests;
import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vev.Reserva;
import com.vev.User;
import com.vev.UserService;
import com.vev.Voo;
import com.vev.VooService;

public class ValoresLimitesTest {

    private VooService vs;
    private UserService us;
    private String origem;
    private String destino;
    private String data;
    private String horario;
    private double preco;
    private int lugares;
    private Voo testVoo;
    private User testUser;

    @BeforeEach
    public void setup() throws Exception, ParseException {
        this.vs = new VooService();
        this.us = new UserService();

        this.origem = "OrigemTeste";
        this.destino = "DestinoTeste";
        this.data = "02/03/1993";
        this.horario = "03:20PM";
        this.lugares = 10;
        this.preco = 20;

        Voo testVoo = this.vs.criaVoo(origem, destino, data, preco, 20, horario);
        this.testVoo = testVoo;

        User testUser = this.us.criaUser("TestUser", "98377776666", "12312312312");
        this.testUser = testUser;
    }

    @Test
    public void testCriaZeroLugar() throws ParseException, Exception {
        assertThrows(Exception.class, () -> {
            this.vs.criaVoo(origem, destino, data, preco, 0, horario);
        });

    }

    @Test
    public void testCriaNegativoLugar() throws ParseException, Exception {
        assertThrows(Exception.class, () -> {
            this.vs.criaVoo(origem, destino, data, preco, -1, horario);
        });

    }

    @Test
    public void testCriaValidoLugar() throws ParseException, Exception {
        Voo newVoo = this.vs.criaVoo(origem, destino, data, preco, 20, horario);
        assertTrue(this.vs.listaVoos().contains(newVoo.detailedToString()));

    }

    @Test
    public void testCriaZeroPreco() throws ParseException, Exception {
        assertThrows(Exception.class, () -> {
            this.vs.criaVoo(origem, destino, data, 0, lugares, horario);
        });
    }

    @Test
    public void testCriaNegativoPreco() throws ParseException, Exception {
        assertThrows(Exception.class, () -> {
            this.vs.criaVoo(origem, destino, data, -1, lugares, horario);
        });

    }

    @Test
    public void testCriaValidoPreco() throws ParseException, Exception {
        Voo newVoo = this.vs.criaVoo(origem, destino, data, 20, lugares, horario);
        assertTrue(this.vs.listaVoos().contains(newVoo.detailedToString()));
    }

    @Test
    public void testReservaNegativoLugar() throws Exception {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), -1, this.us);
        });
    }

    @Test
    public void testReservaZeroLugar() throws Exception {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 0, this.us);
        });
    }

    @Test
    public void testReservaMaxLugar() throws Exception {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 21, this.us);
        });
    }

    @Test
    public void testReservaValido1Lugar() throws Exception {
        Reserva reserva = this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 1, this.us);
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(reserva));
    }

    @Test
    public void testReservaValido2Lugar() throws Exception {
        Reserva reserva = this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 5, this.us);
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(reserva));
    }

    @Test
    public void testReservaValido3Lugar() throws Exception {
        Reserva reserva = this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 19, this.us);
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(reserva));
    }

    @Test
    public void testReservaValido4Lugar() throws Exception {
        Reserva reserva = this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 20, this.us);
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(reserva));
    }

}
