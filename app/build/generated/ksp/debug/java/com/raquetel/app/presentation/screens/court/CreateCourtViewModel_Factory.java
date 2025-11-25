package com.raquetel.app.presentation.screens.court;

import com.raquetel.app.domain.usecases.court.SaveCourtUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class CreateCourtViewModel_Factory implements Factory<CreateCourtViewModel> {
  private final Provider<SaveCourtUseCase> saveCourtUseCaseProvider;

  public CreateCourtViewModel_Factory(Provider<SaveCourtUseCase> saveCourtUseCaseProvider) {
    this.saveCourtUseCaseProvider = saveCourtUseCaseProvider;
  }

  @Override
  public CreateCourtViewModel get() {
    return newInstance(saveCourtUseCaseProvider.get());
  }

  public static CreateCourtViewModel_Factory create(
      Provider<SaveCourtUseCase> saveCourtUseCaseProvider) {
    return new CreateCourtViewModel_Factory(saveCourtUseCaseProvider);
  }

  public static CreateCourtViewModel newInstance(SaveCourtUseCase saveCourtUseCase) {
    return new CreateCourtViewModel(saveCourtUseCase);
  }
}
