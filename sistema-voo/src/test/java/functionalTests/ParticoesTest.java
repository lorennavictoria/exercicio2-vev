package functionalTests;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.vev.Reserva;
import com.vev.User;
import com.vev.UserService;
import com.vev.Util;
import com.vev.Voo;
import com.vev.VooService;

public class ParticoesTest {

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

        this.criaVoosPesquisa();
    }

    @Test
    public void testCriaVooOrigemInvalida() throws Exception, ParseException {
        assertThrows(Exception.class, () -> {
            this.vs.criaVoo("", destino, data, preco, lugares, horario);
        });
    }

    @Test
    public void testCriaVooOrigemValida() throws Exception, ParseException {
        Voo newVoo = this.vs.criaVoo("Campina Grande", destino, data, preco, lugares, horario);
        assertTrue(this.vs.listaVoos().contains(newVoo.detailedToString()));
    }

    @Test
    public void testCriaVooDestinoInvalido() throws Exception, ParseException {
        assertThrows(Exception.class, () -> {
            this.vs.criaVoo(origem, "", data, preco, lugares, horario);
        });
    }

    @Test
    public void testCriaVooDestinoValido() throws Exception, ParseException {
        Voo newVoo = this.vs.criaVoo(origem, "Recife", data, preco, lugares, horario);
        assertTrue(this.vs.listaVoos().contains(newVoo.detailedToString()));
    }

    @Test
    public void testCriaVooDataInvalida1() throws Exception, ParseException {
        assertThrows(ParseException.class, () -> {
            this.vs.criaVoo(origem, destino, "", preco, lugares, horario);
        });
    }

    @Test
    public void testCriaVooDataInvalida2() throws Exception, ParseException {
        assertThrows(ParseException.class, () -> {
            this.vs.criaVoo(origem, destino, "02-03-2023", preco, lugares, horario);
        });
    }

    @Test
    public void testCriaVooDataInvalida3() throws Exception, ParseException {
        assertThrows(ParseException.class, () -> {
            this.vs.criaVoo(origem, destino, "62/03/2023", preco, lugares, horario);
        });
    }

    @Test
    public void testCriaVooDataInvalida4() throws Exception, ParseException {
        assertThrows(ParseException.class, () -> {
            this.vs.criaVoo(origem, destino, "02/13/2023", preco, lugares, horario);
        });
    }

    @Test
    public void testCriaVooDataValida() throws Exception, ParseException {
        Voo newVoo = this.vs.criaVoo(origem, destino, "02/03/2023", preco, lugares, horario);
        assertTrue(this.vs.listaVoos().contains(newVoo.detailedToString()));
    }

    @Test
    public void testCriaVooHorarioInvalido1() throws Exception, ParseException {
        assertThrows(DateTimeParseException.class, () -> {
            this.vs.criaVoo(origem, destino, data, preco, lugares, "");
        });
    }

    @Test
    public void testCriaVooHorarioInvalido2() throws Exception, ParseException {
        assertThrows(DateTimeParseException.class, () -> {
            this.vs.criaVoo(origem, destino, data, preco, lugares, "9am");
        });
    }

    @Test
    public void testCriaVooHorarioValido() throws Exception, ParseException {
        Voo newVoo = this.vs.criaVoo(origem, destino, data, preco, lugares, "09:00AM");
        assertTrue(this.vs.listaVoos().contains(newVoo.detailedToString()));
    }

    @Test
    public void testCadastraNomeInvalido() throws Exception {
        assertThrows(Exception.class, () -> {
            this.us.criaUser("", telefone, cpf);
        });
    }

    @Test
    public void testCadastraNomeValido() throws Exception {
        User newUser = this.us.criaUser("João", telefone, cpf);
        assertTrue(this.us.getUsers().contains(newUser));
    }

    @Test
    public void testCadastraCpfInvalido1() throws Exception {
        assertThrows(Exception.class, () -> {
            this.us.criaUser(nome, telefone, "");
        });
    }

    @Test
    public void testCadastraCpfInvalido2() throws Exception {
        assertThrows(Exception.class, () -> {
            this.us.criaUser(nome, telefone, "123");
        });
    }

    @Test
    public void testCadastraCpfValido() throws Exception {
        User newUser = this.us.criaUser(nome, telefone, "11122233344");
        assertTrue(this.us.getUsers().contains(newUser));
    }

    @Test
    public void testCadastraTelefoneInvalido1() throws Exception {
        assertThrows(Exception.class, () -> {
            this.us.criaUser(nome, "", cpf);
        });
    }

    @Test
    public void testCadastraTelefoneInvalido2() throws Exception {
        assertThrows(Exception.class, () -> {
            this.us.criaUser(nome, "", cpf);
        });
    }

    @Test
    public void testCadastraTelefoneValido() throws Exception {
        User newUser = this.us.criaUser(nome, "81977776666", cpf);
        assertTrue(this.us.getUsers().contains(newUser));
    }

    @Test
    public void testPesquisaVazia() {
        ArrayList<Voo> result = this.vs.pesquisaVoo("", "", "", 0);
        assertTrue(this.containsVoo(result, this.voos));
    }

    @Test
    public void testPesquisaOrigem() {
        ArrayList<Voo> result = this.vs.pesquisaVoo("Campina Grande", "", "", 0);
        assertTrue(this.containsVooOrigem(result, "Campina Grande"));
    }

    @Test
    public void testPesquisaDestino() {
        ArrayList<Voo> result = this.vs.pesquisaVoo("", "Recife", "", 0);
        assertTrue(this.containsVooDestino(result, "Recife"));
    }

    @Test
    public void testPesquisaData1() {
        ArrayList<Voo> result = this.vs.pesquisaVoo("", "", "12/02/2024", 0);
        assertTrue(this.containsVooData(result, "12/02/2024"));
    }

    @Test
    public void testPesquisaData2() {
        assertThrows(Exception.class, () -> {
            this.vs.pesquisaVoo("", "", "12-02-2024", 0);
        });
    }

    @Test
    public void testPesquisaLugares() {
        ArrayList<Voo> result = this.vs.pesquisaVoo("", "", "", 4);
        assertTrue(this.containsVooLugares(result, 20));
    }

    private void criaVoosPesquisa() throws Exception, ParseException {
        this.voos = new ArrayList<>();

        Voo v1 = this.vs.criaVoo("Campina Grande", "Recife", "12/02/2024", 200.0, 40, "09:00AM");
        Voo v2 = this.vs.criaVoo("São Paulo", "Rio de Janeiro", "29/12/2024", 150.5, 30, "08:00PM");
        Voo v3 = this.vs.criaVoo("Rio de Janeiro", "Recife", "10/07/2024", 300.0, 40, "06:30AM");
        Voo v4 = this.vs.criaVoo("Espírito Santo", "Porto Alegre", "01/06/2024", 320.9, 50, "10:00PM");
        Voo v5 = this.vs.criaVoo("Rio de Janeiro", "Manaus", "18/11/2024", 450.0, 45, "09:00AM");

        this.voos.add(v1);
        this.voos.add(v2);
        this.voos.add(v3);
        this.voos.add(v4);
        this.voos.add(v5);
        this.voos.add(this.testVoo);
    }

    private boolean containsVoo(ArrayList<Voo> c1, ArrayList<Voo> c2) {
        for (Voo voo : c1) {
            if (!c2.contains(voo)) {
                return false;
            }
        }
        return true;
    }

    private boolean containsVooOrigem(ArrayList<Voo> c1, String origem) {
        for (Voo voo : c1) {
            if (!voo.getOrigem().equals(origem)) {
                return false;
            }
        }
        return true;
    }

    private boolean containsVooDestino(ArrayList<Voo> c1, String destino) {
        for (Voo voo : c1) {
            if (!voo.getDestino().equals(destino)) {
                return false;
            }
        }
        return true;
    }

    private boolean containsVooData(ArrayList<Voo> c1, String data) {
        for (Voo voo : c1) {
            if (!voo.getDateString().equals(data)) {
                return false;
            }
        }
        return true;
    }

    private boolean containsVooLugares(ArrayList<Voo> c1, int lugares) {
        for (Voo voo : c1) {
            if (voo.getLugaresLivres() < lugares) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testReservaVooCpfVazio() {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(this.testVoo.getId(), "", lugares, us);
        });
    }

    @Test
    public void testReservaVooCpfNaoCadastrado() {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(this.testVoo.getId(), "00000000000", lugares, us);
        });
    }

    @Test
    public void testReservaVooCpfInvalido() {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(this.testVoo.getId(), "123", lugares, us);
        });
    }

    @Test
    public void testReservaVooCpfVCadastrado() throws Exception {
        Reserva reserva = this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), lugares, us);
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(reserva));
    }

    @Test
    public void testReservaVooIdVazio() {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo("", this.testUser.getCpf(), lugares, us);
        });
    }

    @Test
    public void testReservaVooIdNaoExiste() {
        String testId = "111ABC";

        // gera novo ID caso exista um ID igual
        // (assegura que ID testado não existe)
        while (vooContainsId(testId)) {
            testId = this.util.generateId(6);
        }

        // precisa ser final para usar em lambda
        final String finalTestId = testId;

        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(finalTestId, this.testUser.getCpf(), lugares, us);
        });
    }

    private boolean vooContainsId(String id) {
        for (Voo voo : this.voos) {
            if (voo.getId().contains(id)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testReservaVooIdValido() throws Exception {
        Reserva reserva = this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), lugares, us);
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(reserva));
    }

    @Test
    public void testReservaVooLugaresZero() {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 0, us);
        });
    }

    @Test
    public void testReservaVooLugaresMax() {
        assertThrows(Exception.class, () -> {
            this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 21, us);
        });
    }

    @Test
    public void testReservaVooLugaresValidos() throws Exception {
        Reserva reserva = this.vs.reservaVoo(this.testVoo.getId(), this.testUser.getCpf(), 4, us);
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(reserva));
    }

    @Test
    public void testCancelaVooIdVazio() {
        assertThrows(Exception.class, () -> {
            this.vs.cancelaReserva(this.testUser.getCpf(), "");
        });
    }

    @Test
    public void testCancelaVooIdNaoExiste() {
        String testId = "ABC999";

        // gera novo ID caso exista um ID igual
        // (assegura que ID testado não existe)
        while (reservaContainsId(testId)) {
            testId = this.util.generateId(6);
        }

        // precisa ser final para usar em lambda
        final String finalTestId = testId;

        assertThrows(Exception.class, () -> {
            this.vs.cancelaReserva(this.testUser.getCpf(), finalTestId);
        });
    }

    @Test
    public void testCancelaVooCpfAndIdExiste() throws Exception {
        assertTrue(this.vs.getReservas(this.testUser.getCpf()).contains(this.testReserva));

        this.vs.cancelaReserva(this.testUser.getCpf(), this.testReserva.getId());
        
        assertFalse(this.vs.getReservas(this.testUser.getCpf()).contains(this.testReserva));
    }

    private boolean reservaContainsId(String id) {
        for (Reserva reserva : this.vs.getReservas(this.testUser.getCpf())) {
            if (reserva.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void testCancelaVooCpfVazio() {
        assertThrows(Exception.class, () -> {
            this.vs.cancelaReserva("", this.testReserva.getId());
        });
    }

    @Test
    public void testCancelaVooCpfNaoCadastrado() {
        assertThrows(Exception.class, () -> {
            this.vs.cancelaReserva("00000000000", this.testReserva.getId());
        });
    }

    @Test
    public void testCancelaVooCpfInvalido() {
        assertThrows(Exception.class, () -> {
            this.vs.cancelaReserva("123", this.testReserva.getId());
        });
    }

}
