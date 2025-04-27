package org.fipe.api.provessor;

@QuarkusTest
public class MarcaConsumerTest {

    @InjectMock
    FipeClient fipeClient;

    @Inject
    MarcaConsumer marcaConsumer;

    @Inject
    VeiculoRepository veiculoRepository;

    @Test
    public void testProcessMarca() {
        // Mock
        ModelosWrapper wrapper = new ModelosWrapper();
        wrapper.setModelos(List.of(new Modelo("001", "Gol")));

        Mockito.when(fipeClient.getModelos("v1")).thenReturn(wrapper);

        // Test
        marcaConsumer.processMarca("v1");

        // Verify
        Assertions.assertEquals(1, veiculoRepository.count());
        Veiculo veiculo = veiculoRepository.listAll().get(0);
        Assertions.assertEquals("001", veiculo.codigo);
        Assertions.assertEquals("v1", veiculo.marca);
        Assertions.assertEquals("Gol", veiculo.modelo);
    }
}