package domain.usecase;

import domain.model.Stage;

public class CreateCardUseCase {
    private StageRepository stageRepository;

    public CreateCardUseCase(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    public void execute(CreateCardInput input, CreateCardOutput output) {
        Stage stage = stageRepository.getStageById(input.getStageId());
        String cardId = stage.createCard(input.getCardName());  //create card return value negotiable.
        output.setCardId(cardId);
    }
}
