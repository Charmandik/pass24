package ru.tenant.pass24;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import ru.tenant.pass24.authorizationFragments.login.LoginFragment;
import ru.tenant.pass24.authorizationFragments.welcome.WelcomeMainFragment;

public class MainActivity extends AppCompatActivity {
    //todo фильтра в пасс
    //todo выкинуть, если ошибка авторизации
    //todo в фрагменте посещения выставить стандартное время
    //todo возможность провалиться в доверенные лица
    //todo успешно созданный пропуск
    //todo поменять логику кнопкам снизу
    //todo красить желтым номер
    //todo время выводить в формате дд.ИМЯ_МЕСЯЦА
    //todo надпись пополнить в балансе
    //todo возможность редактировать пропуска
    //todo возможность редактировать профиль
    //todo возможность поиска
    //todo прокидывание данных без кнопки назад
    //todo шаблоны
    //todo чатик
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