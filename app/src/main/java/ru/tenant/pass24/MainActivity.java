package ru.tenant.pass24;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.authorizationFragments.login.LoginFragment;
import ru.tenant.pass24.authorizationFragments.welcome.WelcomeMainFragment;

public class MainActivity extends AppCompatActivity {
    //todo поменять логику кнопкам снизу
    //todo выкинуть, если ошибка авторизации
    //todo красить желтым номер
    //todo время выводить в формате дд.ИМЯ_МЕСЯЦА
    //todo надпись пополнить в балансе
    //todo возможность редактировать пропуска
    //todo возможность редактировать профиль
    //todo возможность поиска
    //todo прокидывание данных без кнопки назад
    //todo шаблоны
    //todo чатик
    //todo фильтра в пасс
    //todo иногда не стягиваются данные о профиле
    //todo возможность удалить доверенное лицо
    //todo возможность изменить доверенное лицо
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = this.getSupportFragmentManager();
        if (getIntent().getBooleanExtra("toLogin", false))
            fragmentManager.beginTransaction().add(R.id.flMainContainer, new LoginFragment()).commit();
        else
            fragmentManager.beginTransaction().add(R.id.flMainContainer, new WelcomeMainFragment()).commit();
    }
}