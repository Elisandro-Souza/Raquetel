package com.raquetel.app.presentation.screens.customer;

import com.raquetel.app.domain.usecases.customer.CreateCustomerUseCase;
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
public final class CreateCustomerViewModel_Factory implements Factory<CreateCustomerViewModel> {
  private final Provider<CreateCustomerUseCase> createCustomerUseCaseProvider;

  public CreateCustomerViewModel_Factory(
      Provider<CreateCustomerUseCase> createCustomerUseCaseProvider) {
    this.createCustomerUseCaseProvider = createCustomerUseCaseProvider;
  }

  @Override
  public CreateCustomerViewModel get() {
    return newInstance(createCustomerUseCaseProvider.get());
  }

  public static CreateCustomerViewModel_Factory create(
      Provider<CreateCustomerUseCase> createCustomerUseCaseProvider) {
    return new CreateCustomerViewModel_Factory(createCustomerUseCaseProvider);
  }

  public static CreateCustomerViewModel newInstance(CreateCustomerUseCase createCustomerUseCase) {
    return new CreateCustomerViewModel(createCustomerUseCase);
  }
}
