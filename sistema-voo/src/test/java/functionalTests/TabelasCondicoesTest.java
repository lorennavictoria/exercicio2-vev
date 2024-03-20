package functionalTests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vev.Reserva;
import com.vev.User;
import com.vev.UserService;
import com.vev.Util;
import com.vev.Voo;
import com.vev.VooService;

public class TabelasCondicoesTest {

    private VooService vs;
    private UserService us;
    private Util util;
    private String origem;
    private String destino;
    private String data;
    private String horario;
    private String cpf;
    private String telefone;
    private String nome;
    private double preco;
    private int lugares;
    private Voo testVoo;
    private User testUser;
    private Reserva testReserva;
    private ArrayList<Voo> voos;

    @BeforeEach
    public void setup() throws Exception, ParseException {
        this.vs = new VooService();
        this.us = new UserService();
        this.util = new Util();

        this.origem = "OrigemTeste";
        this.destino = "DestinoTeste";
        this.data = "02/03/1993";
        this.horario = "03:20PM";
        this.lugares = 10;
        this.preco = 20;

        this.nome = "Usuario";
        this.cpf = "99999999999";
        this.telefone = "98144445555";

        Voo testVoo = this.vs.criaVoo(origem, destino, data, preco, 20, horario);
        this.testVoo = testVoo;

        User testUser = this.us.criaUser("TestUser", "98377776666", "12312312312");
        this.testUser = testUser;

        Reserva testReserva = this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 1, this.us);
        this.testReserva = testReserva;
    }

    @Test
    public void testReservaRegra1() throws Exception {
        Reserva reserva = this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 2, this.us);
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(reserva));
    }

    @Test
    public void testReservaRegra2() {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 21, this.us);
        });
    }
    
    @Test
    public void testReservaRegra3e4() {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo("000000", "00000000000", 2, this.us);
        });
    }

    @Test
    public void testCancelamentoRegra1() throws Exception {
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(this.testReserva));

        this.vs.cancelaReserva(this.testUser.getCpf(), this.testReserva.getId());
        
        assertFalse(this.vs.getReservas(this.testUser.getCpf()).contains(this.testReserva));
    }

    @Test
    public void testCancelamentoRegra2() {
        assertThrows(Exception.class, () -> {
            this.vs.cancelaReserva("00000000000", this.testReserva.getId());
        });
    }

    @Test
    public void testCancelamentoRegra3e4() {
        assertThrows(Exception.class, () -> {
            this.vs.cancelaReserva("00000000000", "000000");
        });
    }
}
