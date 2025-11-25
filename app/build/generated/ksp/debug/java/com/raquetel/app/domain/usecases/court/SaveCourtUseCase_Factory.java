package com.raquetel.app.domain.usecases.court;

import com.raquetel.app.domain.repositories.CourtRepository;
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
public final class SaveCourtUseCase_Factory implements Factory<SaveCourtUseCase> {
  private final Provider<CourtRepository> repositoryProvider;

  public SaveCourtUseCase_Factory(Provider<CourtRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public SaveCourtUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static SaveCourtUseCase_Factory create(Provider<CourtRepository> repositoryProvider) {
    return new SaveCourtUseCase_Factory(repositoryProvider);
  }

  public static SaveCourtUseCase newInstance(CourtRepository repository) {
    return new SaveCourtUseCase(repository);
  }
}
