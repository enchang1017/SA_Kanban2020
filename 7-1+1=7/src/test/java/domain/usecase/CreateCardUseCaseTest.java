package domain.usecase;

import domain.model.Stage;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreateCardUseCaseTest {
    private StageRepository stageRepository;
    private String stageId;

    @Before
    public void setup() {
        stageRepository = new StageRepository();
        Stage stage = new Stage("Stage1");
        stageId = stage.getStageId();
        stageRepository.add(stage);
    }

    @Test
    public void createCard() {
        CreateCardUseCase createCardUseCase = new CreateCardUseCase(stageRepository);
        CreateCardInput input = new CreateCardInput();
        CreateCardOutput output = new CreateCardOutput();

        input.setCardName("Card1");
        input.setStageId(stageId);

        createCardUseCase.execute(input, output);

        assertEquals('C', output.getCardId().charAt(0));
    }
}
