package com.equipe.lavemais

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CadastroScreen() {
    val scrollState = rememberScrollState()

    // Estados dos campos preenchidos conforme o mockup
    var nome by remember { mutableStateOf("Ana Clara Lima") }
    var email by remember { mutableStateOf("ana.lima@exemplo.com") }
    var telefone by remember { mutableStateOf("(11) 9••••-4820") }
    var cpf by remember { mutableStateOf("•••.•••.•••-••") }
    var senha by remember { mutableStateOf("••••••••••••") }
    var confirmacaoSenha by remember { mutableStateOf("••••••••••••") }
    var termosAceites by remember { mutableStateOf(true) }

    // Cores extraídas
    val backgroundColor = Color(0xFFFAFAFA)
    val primaryPurple = Color(0xFF673AB7)
    val lightPurpleCard = Color(0xFFF3E5F5)
    val textDark = Color(0xFF212121)
    val textGrey = Color(0xFF757575)
    val successGreen = Color(0xFF4CAF50)
    val errorRed = Color(0xFFD32F2F)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.Start
    ) {
        // Cabeçalho (Botão Voltar e Slogan)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { /* Ação de voltar */ },
                modifier = Modifier
                    .size(48.dp)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xFFEEEEEE), RoundedCornerShape(12.dp))
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = textDark
                )
            }
            Text(
                text = "Cuidado em cada ciclo",
                color = textGrey,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Título e Subtítulo
        Text(
            text = "Seu primeiro ciclo\ncomeça aqui.",
            color = textDark,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 34.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Crie sua conta na Lila. É simples, seguro e sem papelada.",
            color = textGrey,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Banner de Aviso (Preenchimento obrigatório)
        Card(
            colors = CardDefaults.cardColors(containerColor = lightPurpleCard),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Icon(
                    imageVector = Icons.Outlined.Assignment,
                    contentDescription = null,
                    tint = primaryPurple,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Column {
                    Text(
                        text = "Preenchimento obrigatório",
                        color = primaryPurple,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Todos os campos com * são obrigatórios. Abaixo, um exemplo de validação do cadastro.",
                        color = primaryPurple,
                        fontSize = 12.sp,
                        lineHeight = 16.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Campo: Nome completo
        Text(text = "Nome completo *", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = textDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            trailingIcon = { Icon(Icons.Outlined.CheckCircle, contentDescription = "Válido", tint = successGreen) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo: E-mail
        Text(text = "E-mail *", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = textDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            trailingIcon = { Icon(Icons.Outlined.CheckCircle, contentDescription = "Válido", tint = successGreen) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo: Telefone
        Text(text = "Telefone *", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = textDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = telefone,
            onValueChange = { telefone = it },
            trailingIcon = { Icon(Icons.Outlined.CheckCircle, contentDescription = "Válido", tint = successGreen) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Número fictício com exibição protegida.", color = textGrey, fontSize = 12.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo: CPF (Com estado de erro ativo)
        Text(text = "CPF *", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = textDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = cpf,
            onValueChange = { cpf = it },
            trailingIcon = { Icon(Icons.Outlined.ErrorOutline, contentDescription = "Erro", tint = errorRed) },
            isError = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Obrigatório: informe seu CPF para continuar. Ele será exibido de forma protegida.",
            color = errorRed,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo: Senha
        Text(text = "Senha *", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = textDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
            trailingIcon = { Icon(Icons.Outlined.CheckCircle, contentDescription = "Válido", tint = successGreen) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Use no mínimo 8 caracteres, com letras e números.", color = textGrey, fontSize = 12.sp)

        Spacer(modifier = Modifier.height(16.dp))

        // Campo: Confirmação de Senha
        Text(text = "Confirmação de senha *", fontWeight = FontWeight.SemiBold, fontSize = 14.sp, color = textDark)
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = confirmacaoSenha,
            onValueChange = { confirmacaoSenha = it },
            leadingIcon = { Icon(Icons.Outlined.Lock, contentDescription = null) },
            trailingIcon = { Icon(Icons.Outlined.CheckCircle, contentDescription = "Válido", tint = successGreen) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "As senhas coincidem.", color = textGrey, fontSize = 12.sp)

        Spacer(modifier = Modifier.height(24.dp))

        // Checkbox de Termos
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Checkbox(
                checked = termosAceites,
                onCheckedChange = { termosAceites = it },
                colors = CheckboxDefaults.colors(checkedColor = primaryPurple)
            )
            Column(modifier = Modifier.padding(top = 12.dp)) {
                Text(
                    text = "Concordo com o tratamento dos meus dados pessoais para criar minha conta e prestar os serviços da Lila. *",
                    fontSize = 12.sp,
                    color = textDark
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Ler a Política de Privacidade",
                    fontSize = 12.sp,
                    color = primaryPurple,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botão Criar Conta
        Button(
            onClick = { /* Ação de Registo */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = primaryPurple),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Criar conta", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "O cadastro só será concluído após corrigir o campo CPF e manter o consentimento selecionado.",
            color = errorRed,
            fontSize = 10.sp,
            modifier = Modifier.fillMaxWidth(),
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Rodapé de Login
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    append("Já tenho conta · ")
                    withStyle(style = SpanStyle(color = primaryPurple, fontWeight = FontWeight.Bold)) {
                        append("Entrar")
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Exemplo de cadastro · Dados fictícios e protegidos.",
                color = textGrey,
                fontSize = 10.sp
            )
        }

        Spacer(modifier = Modifier.height(48.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CadastroScreenPreview() {
    CadastroScreen()
}
