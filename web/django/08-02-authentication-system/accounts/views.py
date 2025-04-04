from django.shortcuts import render, redirect
from django.contrib.auth.forms import AuthenticationForm
from django.contrib.auth import login as auth_login
from django.contrib.auth import logout as auth_logout

# from django.contrib.auth.forms import UserCreationForm
from .forms import CustomUserCreationForm, CustomUserChangeForm


# Create your views here.
def login(request):
    if request.method == 'POST':
        form = AuthenticationForm(request, request.POST)
        # form = AuthenticationForm(request, data=request.POST)
        if form.is_valid():
            # auth_login(request, 로그인 인증된 유저 객체)
            auth_login(request, form.get_user())
            return redirect('articles:index')
    else:
        form = AuthenticationForm()
    context = {
        'form': form,
    }
    return render(request, 'accounts/login.html', context)


def logout(request):
    auth_logout(request)
    return redirect('articles:index')


def signup(request):
    return render(request, "accounts/signup.html", context)


def delete(request):
    # 유저 객체를 삭제
    # 유저를 조회해야 할까? 필요 없음
    # 애초에 탈퇴라는건 로그인이 되어있는 상태로 요청을 보내기 때문
    # 그래서 요청 객체 안에 이미 어떤 사용자가 요청을 보내는 건지 정보가 들어있음 
    # request.user
    return redirect("articles:index")
    
    
# def update(request):
#     if request.method == "POST":
#         CustomUserChangeForm(request.POST, instance = request.user)
#         if form.is_valid():
#             form.save()
#             return redirect("articls:index")
        
        
#     else:
#         form = CustomUserChangeForm(instance = request.user)
    
#     context = {
#         "form" : form,
#     }
#     return render(request, "accounts/update.html", context)


def update(request):
    if request.method == "POST":
        form = CustomUserChangeForm(request.POST, instance=request.user)
        if form.is_valid():
            form.save()
            return redirect("articles:index")
    else:
        form = CustomUserChangeForm(instance = request.user)
    context = {
        "form" : form,
    }
    
    return render(request, "accounts/update.html", context)




def change_password(request):
    pass












def signup(request):
    if request.method == "POST":
        form = CustomUserCreationForm(request.POST)
        if form.is_valid():
            form.save()
            return redirect("articles:index")
        
    else:
        # 회원가입 템플릿과 회원정보 작성을 위한 form을 응답
        form = CustomUserCreationForm()
    context = {
        "form" :  form,
    }
    return render(request, "accounts/signup.html", context)