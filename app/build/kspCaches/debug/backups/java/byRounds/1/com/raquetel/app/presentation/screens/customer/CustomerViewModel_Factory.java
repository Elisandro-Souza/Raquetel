package com.raquetel.app.presentation.screens.customer;

import com.raquetel.app.domain.usecases.customer.GetCustomersUseCase;
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
public final class CustomerViewModel_Factory implements Factory<CustomerViewModel> {
  private final Provider<GetCustomersUseCase> getCustomersUseCaseProvider;

  public CustomerViewModel_Factory(Provider<GetCustomersUseCase> getCustomersUseCaseProvider) {
    this.getCustomersUseCaseProvider = getCustomersUseCaseProvider;
  }

  @Override
  public CustomerViewModel get() {
    return newInstance(getCustomersUseCaseProvider.get());
  }

  public static CustomerViewModel_Factory create(
      Provider<GetCustomersUseCase> getCustomersUseCaseProvider) {
    return new CustomerViewModel_Factory(getCustomersUseCaseProvider);
  }

  public static CustomerViewModel newInstance(GetCustomersUseCase getCustomersUseCase) {
    return new CustomerViewModel(getCustomersUseCase);
  }
}
